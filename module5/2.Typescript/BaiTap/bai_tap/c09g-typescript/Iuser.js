var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var customer = {
    name: 'Bob',
    age: 50
};
console.log(customer);
var Shape = /** @class */ (function () {
    function Shape(x, y) {
        this.x = x;
        this.y = y;
    }
    Shape.prototype.toString = function () {
        return "(x: " + this.x + ", y: " + this.y + ")";
    };
    return Shape;
}());
var Rect = /** @class */ (function (_super) {
    __extends(Rect, _super);
    function Rect(x, y, width, height) {
        var _this = _super.call(this, x, y) || this;
        _this.width = width;
        _this.height = height;
        return _this;
    }
    Rect.prototype.area = function () {
        return this.width * this.height;
    };
    return Rect;
}(Shape));
var rect = new Rect(5, 5, 10, 20);
console.log(rect.toString());
console.log(rect.area());
