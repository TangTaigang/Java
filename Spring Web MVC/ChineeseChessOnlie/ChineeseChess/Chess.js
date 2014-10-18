Object.clone = function (obj){
    if(obj==null) return null;
    var o = obj.constructor == Array ? [] : {};
    for(var i in obj){
    if(obj.hasOwnProperty(i)){
    o[i] = typeof obj[i] == "object" ? Object.clone(obj[i]) : obj[i];
    }
    }
    return o;
    };
//John Resig大师实现的JS继承机制
//自执行的匿名函数创建一个上下文，避免引入全局变量
(function () {
    // initializing变量用来标示当前是否处于类的创建阶段，
    // - 在类的创建阶段是不能调用原型方法init的
    var initializing = false,
    // fnTest是一个正则表达式，可能的取值为（/\b_super\b/ 或 /.*/）
    // - 对 /xyz/.test(function() { xyz; }) 的测试是为了检测浏览器是否支持test参数为函数的情况。
    fnTest = /xyz/.test(function () {
    xyz;
    }) ? /\b_super\b/ : /.*/;
    // 基类构造函数
    // 这里的this是window，所以就为这整段代码提供了一个对外的接口 - window.Class
    this.Class = function () {};
    // 继承方法定义
    Class.extend = function (prop) {
    // 注意：_super指向父类的原型对象
    // - this具体指向什么不是定义时能决定的，而是要看此函数是怎么被调用的
    // - 我们已经知道extend肯定是作为方法调用的，而不是作为构造函数
    // - 所以这里this指向的不是Object，而是Function（即是Class），那么this.prototype就是父类的原型对象
    var _super = this.prototype;
    // 通过将子类的原型指向父类的一个实例对象来完成继承
    // - 注意：this是基类构造函数（即是Class）
    initializing = true;
    var prototype = new this();
    initializing = false;
    // 拷贝prop中的所有属性到子类原型中
    for (var name in prop) {
    // 如果prop和父类中存在同名的函数，并且此函数中使用了_super方法，则对此方法进行特殊处理
    // 否则将此方法prop[name]直接赋值给子类的原型
    prototype[name] = typeof prop[name] == "function" && typeof _super[name] == "function" && fnTest.test(prop[name]) ? (function (name, fn) {
    // 特殊处理：如果父类和子类有同名方法，并且子类中此方法（name）通过_super调用了父类方法
    // - 则重新定义此方法
    return function () {
    // 将实例方法_super保护起来。
    var tmp = this._super;
    // 在执行子类的实例方法name时，添加另外一个实例方法_super，此方法指向父类的同名方法
    this._super = _super[name];
    // 执行子类的方法name，注意在方法体内this._super可以调用父类的同名方法
    var ret = fn.apply(this, arguments);
    this._super = tmp;
    // 返回执行结果
    return ret;
    };
    })(name, prop[name]) : prop[name];
    }
    // 注意：这里的Class不是在最外层定义的那个基类构造函数
    // - 使用一个同名的局部变量来覆盖全局变量
    function Class() {
    // 在类的实例化时，调用原型方法create
    if (!initializing && this.create) this.create.apply(this, arguments);
    }
    // 子类的prototype指向父类的实例（完成继承的关键）
    Class.prototype = prototype;
    // 修正constructor指向错误
    Class.constructor = Class;
    // 子类自动获取extend方法，arguments.callee指向当前正在执行的函数
    Class.extend = arguments.callee;
    return Class;
    };
    })();
// 点
var Point = Class.extend({
    //坐标
    x: 0,
    y: 0,
    //构造函数
    create: function (x, y) {
    this.x = x;
    this.y = y;
    },
    //移动，参数：偏移量
    move: function (dx, dy) {
    this.x += dx;
    this.y += dy;
    },
    //移动到，参数：坐标
    moveTo: function (x, y) {
    this.x = x;
    this.y = y;
    },
    //点重合
    equals: function (point) {
    return this.x == point.x && this.y == point.y;
    },
    //序列化
    toString: function () {
    return "(" + this.x + ", " + this.y + ")";
    }
    });
// 边与坐标轴平行的矩形
var Rect = Class.extend({
    //边界
    left: 0,
    top: 0,
    right: 0,
    bottom: 0,
    //构造函数
    create: function (left, top, right, bottom) {
    this.left = left;
    this.top = top
    this.right = right;
    this.bottom = bottom;
    },
    //get：宽度
    width: function () {
    return this.right - this.left;
    },
    //get：高度
    height: function () {
    return this.bottom - this.top;
    },
    //矩形平移，参数：偏移量
    move: function (dx, dy) {
    this.left += dx;
    this.right += dx;
    this.top += dy;
    this.bottom += dy;
    },
    //矩形平移到，参数：左边沿和上边沿
    moveTo: function (x, y) {
    this.right = x + this.width();
    this.bottom = y + this.height();
    this.left = x;
    this.top = y;
    },
    //点在矩形内
    isPointIn: function (point) {
    return this.left <= point.x && this.right > point.x && this.top <= point.y && this.bottom > point.y;
    },
    //矩形重叠
    isOverlap: function (rc) {
    return !(this.left >= rc.right || this.right <= rc.left || this.top >= rc.bottom || this.bottom <= rc.top);
    },
    //矩形相等，即完全重叠
    equals: function (rc) {
    return this.left == rc.left && this.top == rc.top && this.right == rc.right && this.bottom == rc.bottom;
    },
    //序列化
    toString: function () {
    return "[" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + "]";
    }
    });
// 组件基类
var Widget = Class.extend({
    id: null,
    parent: null,
    children: null,
    offsetRect: null,
    canvas: null,
    //构造函数
    create: function (id, parent, canvas) {
    this.id = id || "_id_" + Math.random();
    this.parent = parent;
    this.canvas = canvas || (this.parent ? this.parent.canvas : null);
    this.children = new Array();
    this.offsetRect = new Rect(0, 0, 0, 0);
    if (this.parent != null) this.parent.addChild(this);//添加给父组件
    },
    //遍历子组件，绘图
    init: function () {
    this.eachChild(function (el) {
    el.onPaint();
    });
    },
    //鼠标按下时的默认处理，遍历子组件，检测鼠标触发的组件，调用相应事件
    //-允许重载。
    onMouseDown: function (point) {
    this.eachChild(function (el) {
    if (el.hitTest(point)) {
    el.onMouseDown(point);
    return true;
    } else {
    return false;
    }
    }, true);
    },
    //默认将鼠标弹起时的事件委托给相应子组件
    //-允许重写
    onMouseUp: function (point) {
    this.eachChild(function (el) {
    if (el.hitTest(point)) {
    el.onMouseUp(point);
    return true;
    } else {
    return false;
    }
    }, true);
    },
    //默认将鼠标移动事件委托给相应子组件
    //-允许重写
    onMouseMove: function (point) {
    this.eachChild(function (el) {
    return el.onMouseMove(point);
    }, true);
    },
    //重绘
    //-子类必须重写
    onPaint: function (canvas) {},
    //添加子组件
    addChild: function (child) {
    if (!this.hasChild(child)) {
    this.children.push(child);
    }
    child.parent = this;
    },
    //判断是否包含某个子组件
    hasChild: function (child) {
    for (var i = 0; i < this.children.length; i++) {
    if (this.children[i] == child) return true;
    }
    return false;
    },
    //顺序或逆序遍历子组件
    eachChild: function (callback, reverse) {
    if (reverse) {
    for (var i = this.children.length - 1; i >= 0; i--) {
    if (callback(this.children[i])) break;
    }
    } else {
    for (var i = 0; i < this.children.length; i++) {
    if (callback(this.children[i])) break;
    }
    }
    },
    //将指定子组件移到最上层
    moveChildToTop: function (child) {
    child = this.removeChild(child);
    if (child != null) this.children.push(child);
    },
    //移除指定子组件
    removeChild: function (child) {
    for (var i = 0; i < this.children.length; i++) {
    if (this.children[i] == child) return this.children.splice(i, 1)[0];
    }
    },
    //碰撞测试
    hitTest: function (point) {
    return this.offsetRect.isPointIn(point);
    },
    //显示
    show: function () {
    this.redraw();
    },
    //重绘
    //-先重绘本组件，然后重绘所有子组件
    redraw: function () {
    this.onPaint();
    this.eachChild(function (el) {
    el.redraw();
    });
    },
    //移除组件
    //-先移除子组件，然后移除本组件
    onDestroy: function () {
    this.eachChild(function (el) {
    el.onDestroy();
    });
    this.children = [];
    if (this.parent != null) this.parent.removeChild(this);
    },
    //序列化
    toString: function () {
    return this.id;
    }
    });
// 浏览器组件基类
var RootWidget = Widget.extend({
    //构造
    create: function (id, canvas) {
    this._super(id, null, canvas);
    },
    //初始化，绑定事件
    init: function () {
    var _this = this;
    // canvas鼠标事件绑定
    // -子类须实现监听函数onMouseMove、onMouseDown和onMouseUp
    document.onmousedown = document.ontouchstart = function (e) {
    e = e || window.event;
    _this.onMouseDown(_this.getFixedMousePoint(e, _this.canvas));
    };
    document.onmouseup = document.ontouchend = function (e) {
    e = e || window.event;
    _this.onMouseUp(_this.getFixedMousePoint(e, _this.canvas));
    };
    document.onmousemove=document.ontouchend=function (e) {
    e = e || window.event;
    _this.onMouseMove(_this.getFixedMousePoint(e, _this.canvas));
    };
    this.getFixedMousePoint = function (e, dom) {
    var x = e.pageX - dom.offsetLeft;
    var y = e.pageY - dom.offsetTop;
    return new Point(x, y);
    };
    }
    });