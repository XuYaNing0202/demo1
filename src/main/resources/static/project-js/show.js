// body
function leftMenu() {
    $("#InstitutionalManagement").hide();
    $("#userManagement").hide();
    $("#reportingData").hide();
    $("#forecastData").hide();
}

function viewDataBtnClick() {
    $("#ViewData").show();
    $("#InstitutionalManagement").hide();
    $("#userManagement").hide();
    $("#forecastData").hide();
    $("#reportingData").hide();
}

function InstitutionalManagementBtn() {
    var flag = permission();
    if (!flag) {
        alert("你的权限不够");
    } else {
        $("#InstitutionalManagement").show();
        $("#ViewData").hide();
        $("#userManagement").hide();
        $("#forecastData").hide();
        $("#reportingData").hide();
    }
}

function userManagementBtnClick() {
    var flag = permission();
    if (!flag) {
        alert("你的权限不够");
    } else {
        $("#userManagement").show();
        $("#ViewData").hide();
        $("#InstitutionalManagement").hide();
        $("#forecastData").hide();
        $("#reportingData").hide();
    }
}

function forecastDataBtnClick() {
    $("#forecastData").show();
    $("#ViewData").hide();
    $("#InstitutionalManagement").hide();
    $("#userManagement").hide();
    $("#reportingData").hide();
}

function reportingDataBtnClick() {
    $("#reportingData").show();
    $("#reportingDataTable").bootstrapTable("destroy");
    reportingDataTable();
    $("#forecastData").hide();
    $("#ViewData").hide();
    $("#InstitutionalManagement").hide();
    $("#userManagement").hide();
}

//权限
function permission() {
    var flag = false;
    $.post({
        url: "/user/permission",
        async: false,
        success: function (data) {
            if (data < 2) {
                flag = true;
            } else {
                flag = false;
            }
        }
    }, "json");
    if (flag) {
        return true;
    }
    return false;
}

function CityDataBootstrapTable(startTime, endTime) {
    $("#dataTable").bootstrapTable({
        url: "/TbCityData/cityDataList",
        method: "get",
        striped: true,
        pagination: true,
        sortable: true,
        sortOrder: "asc",
        clickToSelect: true,
        pageNumber: 1,
        pageSize: 5,
        queryParams: function () {
            return {"startTime": startTime, "endTime": endTime};
        },
        columns: [
            {checkbox: true, visible: true},
            {field: "institutionName", title: "机构名称"},
            {field: "plannedQuantity", title: "预计开桌数"},
            {field: "actualQuantity", title: "实际开桌数"},
            {
                field: "exacutiveRate", title: "执行率",
                formatter: function (value, row, index) {
                    return value + "%";
                }
            },
            {field: "newClient", title: "新客户"},
            {field: "oldClient", title: "老客户"},
            {field: "intentionClient", title: "意向客户"},
            {field: "estimatedPremium", title: "预估保费(万元)"}
        ]
    });
}

function selectBtnClick() {
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    $("#dataTable").bootstrapTable("destroy");
    CityDataBootstrapTable(startTime, endTime);
    echartsShow(startTime, endTime);
    main2Pie(startTime, endTime);
}

// 注销
function logOUt() {
    window.location.href = "logIn";
}

function InstitutionalManagementZtreeMethod() {
    $.post({
        url: "/area/areaList",
        success: function (data) {
            var setting = {
                async: {
                    enable: true
                },
                edit: {
                    enable: true,
                    editNameSelectAll: true,
                    showRemoveBtn: showRemoveBtn
                },
                view: {
                    addHoverDom: addHoverDom, //当鼠标移动到节点上时，显示用户自定义控件
                    removeHoverDom: removeHoverDom, //离开节点时的操作
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "parentId",
                        rootPId: "0"
                    },
                    key: {
                        name: "areaName"
                    }
                },
                callback: {
                    beforeRename: beforeRename,
                    beforeRemove: beforeRemove,
                    onRemove: onRemove, //移除事件
                    onRename: onRename //修改事件
                }
            };
            $.fn.zTree.init($("#InstitutionalManagementZtree"), setting, data);
        }
    }, "json");

}

// 添加节点
function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='添加子节点' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    var btn = $("#addBtn_" + treeNode.tId);
    if (btn) btn.bind("click", function () {
        //在这里向后台发送请求保存一个新建的叶子节点，父id为treeNode.id,让后将下面的100+newCount换成返回的id
        //zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"新建节点" + (newCount++)});
        $("#addZtree").modal("show");
        $("#addTreeBtn").click(function () {
            var flag = true;
            if (treeNode.isParent) flag = permission();
            if (!flag) {
                alert("权限不够");
                window.location.reload();
            } else {
                $.post({
                    url: "/area/insertArea",
                    data: {"areaName": $("input[name=areaName]").val(), "parentId": treeNode.id},
                    success: function (data) {
                        if (data) {
                            alert("Success");
                            window.location.reload();
                        } else {
                            alert("fail");
                        }
                    }
                }, "json");
            }
        });
    });
}

// 鼠标移开
function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.tId).unbind().remove();
}

// 修改前的判断
function beforeRename(treeId, treeNode, newName, isCancel) {
    if (newName.length == 0) {
        alert("节点名称不能为空.");
        return false;
    }
    return true;
}

// 修改
function onRename(e, treeId, treeNode, isCancel) {
    //需要对名字做判定的，可以来这里写~~
    permission();
    $.post({
        url: "/area/updateArea",
        data: {"id": treeNode.id, "areaName": treeNode.areaName},
        success: function (data) {
            if (data) {
                alert("Success");
            } else {
                alert("fail");
            }
        }
    }, "json");
}

// 删除前的判断
function beforeRemove(treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("InstitutionalManagementZtree");
    zTree.selectNode(treeNode);
    return confirm("确认删除 节点 -- " + treeNode.areaName + " 吗？");
}

function showRemoveBtn(treeId, treeNode) {
    return !treeNode.isParent;
}

// 删除
function onRemove(e, treeId, treeNode) {
    $.post({
        url: "/area/deleteArea",
        data: {"id": treeNode.id},
        success: function (data) {
            if (data) {
                alert("Success!");
            } else {
                alert("fail");
            }
        }
    }, "json");
}

// 地图
function echartsShow(startTime, endTime) {

    $.post({
        url: "/TbCityData/cityDataList",
        data: {"startTime": startTime, "endTime": endTime},
        success: function (DataMap) {

            var dataValue = [];

            for (var i = 0; i < DataMap.length; i++) {
                dataValue.push({name: DataMap[i].institutionName, value: DataMap[i].estimatedPremium});
            }

            var myChart = echarts.init(document.getElementById("main"));

            myChart.showLoading();

            $.get("/echarts/HE.json", function (geoJson) {

                myChart.hideLoading();

                echarts.registerMap('HE', geoJson);

                myChart.setOption(option = {
                    title: {
                        text: '河北省预估保险',
                        subtext: '以万元计算',
                        sublink: 'http://zh.wikipedia.org/wiki/%E9%A6%99%E6%B8%AF%E8%A1%8C%E6%94%BF%E5%8D%80%E5%8A%83#cite_note-12'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{b}<br/>预估保险:({c}万元)'
                    },
                    toolbox: {
                        show: true,
                        orient: 'vertical',
                        left: 'right',
                        top: 'center',
                        feature: {
                            dataView: {readOnly: false},
                            restore: {},
                            saveAsImage: {}
                        }
                    },
                    visualMap: {
                        min: 5,
                        max: 500,
                        text: ['High', 'Low'],
                        realtime: false,
                        calculable: true,
                        inRange: {
                            color: ['lightskyblue', 'yellow', 'orangered']
                        }
                    },
                    series: [
                        {
                            name: '河北省预估保险',
                            type: 'map',
                            mapType: 'HE', // 自定义扩展图表类型
                            itemStyle: {
                                normal: {label: {show: true}},
                                emphasis: {label: {show: true}}
                            },
                            data: dataValue,
                        }
                    ]
                });
            });
        }
    }, "json");
}

// 饼状图
function main2Pie(startTime, endTime) {

    $.post({
        url: "/TbCityData/cityDataList",
        data: {"startTime": startTime, "endTime": endTime},
        success: function (DataMap) {

            var dataValue = [];

            for (var i = 0; i < DataMap.length; i++) {
                dataValue.push({name: DataMap[i].institutionName, value: DataMap[i].estimatedPremium});
            }

            var myEchart = echarts.init(document.getElementById("main2"));

            myEchart.setOption(option = {
                tooltip: {
                    trigger: "item",
                    formatter: "{a}<br/>{b}:{c}万元"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                },
                series: [{
                    name: "预估保费",
                    type: "pie",
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data: dataValue
                }]
            })

        }
    }, "json");
}


//User Management
function UserManagementZtree() {
    $.post({
        url: "/area/areaList",
        success: function (data) {
            var setting = {
                async: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "parentId",
                        rootPId: "0"
                    },
                    key: {
                        name: "areaName"
                    }
                },
                callback: {
                    onClick: zTreeOnClick, //单击事件
                }
            };
            $.fn.zTree.init($("#userManagementZtree"), setting, data);
        }
    }, "json");
}

function zTreeOnClick(event, treeId, treeNode) {
    // alert(treeNode.id);
    $("#areaId").val(treeNode.id);
    $("#userManagementAddUser").show();
    $("#userManagementTable").bootstrapTable("destroy");
    userManagementTable(treeNode.id);
}

function userManagementTable(id) {
    $("#userManagementTable").bootstrapTable({
        url: "/user/ztreeAll",
        method: "get",
        striped: true,
        pagination: true,
        sortable: true,
        sortOrder: "asc",
        clickToSelect: true,
        pageNumber: 1,
        pageSize: 5,
        queryParams: function () {
            return {"id": id};
        },
        columns: [
            {checkbox: true, visible: true},
            {field: "username", title: "名称"},
            {field: "account", title: "code信息"},
            {field: "permission", title: "级别"},
            {
                field: "id", title: "操作",
                formatter: function (value, row, index) {
                    return "";
                }
            }
        ]
    });
}

// add user
function userManagementAddUser() {
    $("#addUser").modal("show");
}

function adduser() {
    $.post({
        async: false,
        url: "/user/insertUser",
        data: $("#userForm").serialize(),
        success: function (data) {
            if (data) {
                alert("添加成功");
                $("#addUser").modal("hide");
                $("#userManagementTable").bootstrapTable("refresh");
            } else {
                alert("添加失败");
            }
        }
    }, 'json');
}

//forecast data
function forecastDataSubmitBtn() {
    $.post({
        url: "/TbDataManagement/forecastData",
        data: $("#forecastDataForm").serialize(),
        success: function (data) {
            if (data) {
                alert("提交成功");
            } else {
                alert("提交失败");
            }
        }
    }, "json");
}

//reporting data
function reportingDataTable() {
    $("#reportingDataTable").bootstrapTable({
        url: "/TbDataManagement/listDataManagement",
        method: "get",
        stripd: true,
        sortable: true,
        sortOrder: "asc",
        clickToSelect: true,
        pageNumber: 1,
        pageSize: 5,
        columns: [
            {field: "planName", title: "plan name"},
            {field: "planNumber", title: "plan number"},
            {field: "createtime", title: "createtime"},
            {
                field: "id", title: "operating",
                formatter: function (value, row, index) {
                    return "<a href='javascript:reportingDataTableBtn(" + row.id + ");'>report</a>";
                }
            }
        ]
    })
}

function reportingDataTableBtn(tdmId) {
    $("#reportingDataModal").modal("show");
    $("#tdmId").val(tdmId);
}

function reportBtn() {
    $.post({
        url: "/report/reporting",
        data: $("#reportingDataForm").serialize(),
        success: function (data) {
            if (data) {
                alert("Successful! Upload Images please...");
                $("#imageModal").modal("show");
            } else {
                alert("failed");
            }
        }
    }, "json");
}

var formData = new FormData();

function selectImg(obj) {
    var Url = window.URL.createObjectURL(obj.files[0]);
    $('#uploadImg').before("<div class=\"uploadDel\" style=\"width: 120px;height: 100px;display:inline-block;\"><img src=\"" + Url + "\" style=\"height: 100px;width: 100px;\"></div>");
    formData.append("multipartFiles",obj.files[0]);
}

function uploadImage() {
    $.post({
        url: "/report/uploadImage",
        async: false,
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data) {
                alert("successful!");
                $("#imageModal").modal("hide");
                $("#reportingDataModal").modal("hide");
            } else {
                alert("failed");
            }
        }
    }, "json")
}

$(function () {
    leftMenu();
    $("input[type=file]").hide();
    InstitutionalManagementZtreeMethod();
    $("#userManagementAddUser").hide();
    UserManagementZtree();
    CityDataBootstrapTable();
    echartsShow();
    main2Pie();
});