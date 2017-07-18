<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="clearfix"></div>
<div class="col-md-12">
    <button class="btn btn-primary float-right" id="subBT" type="submit" form="subform" style="margin-bottom: 10px">保存</button>
    <form id="subform" id="subForm" method="post" action="apiHandler2/saveApiParams">
        <input name="apiID" type="hidden" value="${param.apiID}"/>
        <input name="projectid" type="hidden" value="${param.projectid}"/>
        <h3>${apiobj.apititle}</h3>
        <div class="form-group">
            <div class="form-inline">
                <label class="mr-sm-2">请求类型</label>
                <input type="hidden" value="${apiobj.formmethod}"/>
                <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="formMethod" setVal="${apiobj.formmethod}">
                    <option selected value="post">post</option>
                    <option value="get">get</option>
                </select>
                <label class="mr-sm-2">接口地址</label>
                <input name="interfaceURL" type="text" required errInfo="接口地址不能为空！"
                       class="form-control mb-2 mr-sm-2 mb-sm-0"
                       value="${apiobj.interfaceurl}"
                       placeholder="接口地址">
            </div>
        </div>
        <div class="form-group">
            <label class="mr-sm-2">接口描述</label>
            <textarea class="form-control  mb-2 mr-sm-2 mb-sm-0" rows="3" cols="100"
                      name="description">${apiobj.description}</textarea>
        </div>
        <div style="max-height: 400px;overflow: auto;">
            <div id="requestDIVID">
                <h6>
                    <button id="requestBaseID"
                            class="btn btn-primary-outline waves-effect waves-light"><span>请求参数添加</span><i
                            class="fa fa-wrench m-l-5"></i></button>
                </h6>
                <c:if test="${paramListRquest==null}">
                    <%--一行三列开始--%>
                    <div class="form-group">
                        <input name="rquestParamUID" type="hidden" value="-1"/>
                        <div class="form-inline">
                            <label class="mr-sm-2">参数名</label>
                            <input name="rquestParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="请求参数名" required
                                   value="${obj.paramname}"
                                   errInfo="请求参数名不能为空！">

                            <label class="mr-sm-2">参数类型</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamType">
                                <option selected>string</option>
                                <option>number</option>
                            </select>

                            <label class="mr-sm-2">是否必填</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamrequired"
                                    setVal="${obj.paramrequired}">
                                <option value="是" selected>是</option>
                                <option value="否">否</option>
                            </select>

                            <label class="mr-sm-2">备注</label>
                            <input name="rquestParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="请求参数备注"
                                   value="${obj.parambeizhu}"
                                   required
                                   errInfo="请求参数备注不能为空！">
                                <%--添加按钮--%>
                            <div class="form-group">
                                <button id="addRequestBTID_"
                                        class="btn btn-success-outline btn-rounded waves-effect waves-light">添加
                                </button>
                            </div>
                                <%--添加按钮结束--%>
                        </div>
                    </div>
                </c:if>

                <c:forEach items="${paramListRquest}" var="obj" varStatus="stat">
                    <%--一行三列开始--%>
                    <div class="form-group">
                        <input name="rquestParamUID" type="hidden" value="${obj.uid}"/>
                        <div class="form-inline">
                            <label class="mr-sm-2">参数名</label>
                            <input name="rquestParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="请求参数名" required
                                   value="${obj.paramname}"
                                   errInfo="请求参数名不能为空！">

                            <label class="mr-sm-2">参数类型</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamType"
                                    setVal="${obj.paramtype}">
                                <option selected>string</option>
                                <option>number</option>
                            </select>

                            <label class="mr-sm-2">是否必填</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamrequired"
                                    setVal="${obj.paramrequired}">
                                <option value="是" selected>是</option>
                                <option value="否">否</option>
                            </select>

                            <label class="mr-sm-2">备注</label>
                            <input name="rquestParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="请求参数备注"
                                   value="${obj.parambeizhu}"
                                   required
                                   errInfo="请求参数备注不能为空！">

                                <%--添加按钮--%>
                            <div class="form-group">
                                <button id="addRequestBTID_${obj.uid}"
                                        class="btn btn-success-outline btn-rounded waves-effect waves-light mr-sm-2">添加
                                </button>
                                <button id="delRequestBTID_${obj.uid}"
                                        class="btn btn-danger-outline btn-rounded waves-effect waves-light">删除
                                </button>
                            </div>
                                <%--添加按钮结束--%>
                        </div>
                    </div>
                </c:forEach>
            </div>


            <div id="responseDIVID">
                <%--一行三列结束--%>
                <h6>
                    <button id="resposeBaseID"
                            class="btn btn-primary-outline waves-effect waves-light"><span>返回参数添加</span><i
                            class="fa fa-wrench m-l-5"></i></button>
                </h6>
                <c:if test="${paramListResponse==null}">
                    <%--一行三列开始--%>
                    <div class="form-group">
                        <input name="responseParamUID" type="hidden" value="-1"/>
                        <div class="form-inline">
                            <label class="mr-sm-2">参数名</label>
                            <input name="responseParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="返回参数名" required
                                   value="${obj.paramname}"
                                   errInfo="返回参数名不能为空！">

                            <label class="mr-sm-2">参数类型</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamType">
                                <option selected>string</option>
                                <option>number</option>
                            </select>

                            <label class="mr-sm-2">是否必填</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamrequired"
                                    setVal="${obj.paramrequired}">
                                <option value="是" selected>是</option>
                                <option value="否">否</option>
                            </select>

                            <label class="mr-sm-2">备注</label>
                            <input name="responseParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="返回参数备注"
                                   value="${obj.parambeizhu}"
                                   required
                                   errInfo="返回参数备注不能为空！">

                                <%--添加按钮--%>
                            <div class="form-group">
                                <button id="addResponseBTID_"
                                        class="btn btn-success-outline btn-rounded waves-effect waves-light">添加
                                </button>
                            </div>
                                <%--添加按钮结束--%>
                        </div>
                    </div>
                </c:if>
                <c:forEach items="${paramListResponse}" var="obj" varStatus="stat">
                    <%--一行三列开始--%>
                    <div class="form-group">
                        <input name="responseParamUID" type="hidden" value="${obj.uid}"/>
                        <div class="form-inline">
                            <label class="mr-sm-2">参数名</label>
                            <input name="responseParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="返回参数名" required
                                   value="${obj.paramname}"
                                   errInfo="返回参数名不能为空！">

                            <label class="mr-sm-2">参数类型</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamType"
                                    setVal="${obj.paramtype}">
                                <option selected>string</option>
                                <option>number</option>
                            </select>

                            <label class="mr-sm-2">是否必填</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamrequired"
                                    setVal="${obj.paramrequired}">
                                <option value="是" selected>是</option>
                                <option value="否">否</option>
                            </select>

                            <label class="mr-sm-2">备注</label>
                            <input name="responseParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                                   placeholder="返回参数备注"
                                   value="${obj.parambeizhu}"
                                   required
                                   errInfo="返回参数备注不能为空！">

                                <%--添加按钮--%>
                            <div class="form-group">
                                <button id="addResponseBTID_${obj.uid}"
                                        class="btn btn-success-outline btn-rounded waves-effect waves-light mr-sm-2">添加
                                </button>
                                <button id="delResponseBTID_${obj.uid}"
                                        class="btn btn-danger-outline btn-rounded waves-effect waves-light">删除
                                </button>
                            </div>
                                <%--添加按钮结束--%>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
        <%--一行三列结束--%>
    </form>
</div>

<script language="javascript" type="text/javascript">
    jQuery(document).ready(function () {
        $.getScript("assets/js/pajaxapimain/projectapi/addapi.js");
    });
</script>

