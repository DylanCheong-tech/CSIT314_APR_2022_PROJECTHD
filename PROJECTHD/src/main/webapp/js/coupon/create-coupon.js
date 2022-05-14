var alert_success_message = "Create Coupon Successful";
var alert_fail_message = "Create Coupon Fail";
var redirect_address = "/restaurantmanager/create-coupon.html";

var coupon_list = $.ajax({
    async: false,
    "url": "/getCouponList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

document.getElementById("id-input").value = parseInt(coupon_list.length != 0 ? coupon_list[coupon_list.length - 1].couponID : 0) + 1;