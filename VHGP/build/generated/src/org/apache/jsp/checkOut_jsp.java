package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkOut_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Thông tin đơn hàng</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n");
      out.write("        <!-- Demo CSS (No need to include it into your project) -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/demo.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/tiny-slider.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/aos.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            @import url('https://fonts.googleapis.com/css?family=Roboto&display=swap');\r\n");
      out.write("            @import url('https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');\r\n");
      out.write("            *{ margin: 0; padding: 0;}\r\n");
      out.write("            body{\r\n");
      out.write("                font-family: 'Roboto', sans-serif;\r\n");
      out.write("                font-style: normal;\r\n");
      out.write("                font-weight: 300;\r\n");
      out.write("                font-smoothing: antialiased;\r\n");
      out.write("                -webkit-font-smoothing: antialiased;\r\n");
      out.write("                -moz-osx-font-smoothing: grayscale;\r\n");
      out.write("                font-size: 15px;\r\n");
      out.write("                background: #fff;\r\n");
      out.write("            }\r\n");
      out.write("            .menu-bg-wrap{\r\n");
      out.write("                background: rgba(10,50,30,0.95);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .intro{\r\n");
      out.write("                background: #fff;\r\n");
      out.write("                padding: 60px 30px;\r\n");
      out.write("                color: #333;\r\n");
      out.write("                margin-bottom: 15px;\r\n");
      out.write("                line-height: 1.5;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            .intro h1 {\r\n");
      out.write("                font-size: 18pt;\r\n");
      out.write("                padding-bottom: 15px;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            .intro p{\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .action{\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .btn{\r\n");
      out.write("                border-radius: 30px;\r\n");
      out.write("            }\r\n");
      out.write("            .btn-primary{\r\n");
      out.write("                background-color: rgba(10,50,30,0.95);\r\n");
      out.write("                border-color: rgba(10,50,30,0.95);\r\n");
      out.write("            }\r\n");
      out.write("            a.btn {\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                color: #fff;\r\n");
      out.write("                border: 2px solid #fff;\r\n");
      out.write("                padding: 10px 15px;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                margin-left: 5px;\r\n");
      out.write("            }\r\n");
      out.write("            a.btn:hover{\r\n");
      out.write("                background: #666;\r\n");
      out.write("                color: #fff;\r\n");
      out.write("                transition: .3s;\r\n");
      out.write("                -webkit-transition: .3s;\r\n");
      out.write("            }\r\n");
      out.write("            /*            .insert a{\r\n");
      out.write("                            background-color: rgba(10,50,30,0.95);\r\n");
      out.write("                            color: white;\r\n");
      out.write("                            border-radius: 25px;\r\n");
      out.write("                            padding: 10px;\r\n");
      out.write("                            border-collapse: 20px;\r\n");
      out.write("                            text-decoration: none;\r\n");
      out.write("                            font-size: 15px;\r\n");
      out.write("                        }*/\r\n");
      out.write("            .insert{\r\n");
      out.write("                /*                text-align: right;*/\r\n");
      out.write("                margin-bottom: 80px;\r\n");
      out.write("            }\r\n");
      out.write("            .insert .order{\r\n");
      out.write("                float:left;\r\n");
      out.write("            }\r\n");
      out.write("            .insert .cancel{\r\n");
      out.write("                float: right;\r\n");
      out.write("                /*                padding-left: 25px;    \r\n");
      out.write("                                padding-right: 25px;*/\r\n");
      out.write("            }\r\n");
      out.write("            .btn:before{\r\n");
      out.write("                font-family: FontAwesome;\r\n");
      out.write("                font-weight: normal;\r\n");
      out.write("                margin-right: 10px;\r\n");
      out.write("            }\r\n");
      out.write("            .btn-primary:hover{\r\n");
      out.write("                background-color: #198754;\r\n");
      out.write("                border-color: #198754;\r\n");
      out.write("            }\r\n");
      out.write("            .github:before{content: \"\\f09b\"}\r\n");
      out.write("            .down:before{content: \"\\f019\"}\r\n");
      out.write("            .back:before{content:\"\\f112\"}\r\n");
      out.write("            .credit{\r\n");
      out.write("                background: #fff;\r\n");
      out.write("                padding: 12px;\r\n");
      out.write("                font-size: 9pt;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                color: #333;\r\n");
      out.write("                margin-top: 40px;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            .credit span:before{\r\n");
      out.write("                font-family: FontAwesome;\r\n");
      out.write("                color: #e41b17;\r\n");
      out.write("                content: \"\\f004\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            .credit a{\r\n");
      out.write("                color: #333;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("            }\r\n");
      out.write("            .credit a:hover{\r\n");
      out.write("                color: #1DBF73; \r\n");
      out.write("            }\r\n");
      out.write("            .credit a:hover:after{\r\n");
      out.write("                font-family: FontAwesome;\r\n");
      out.write("                content: \"\\f08e\";\r\n");
      out.write("                font-size: 9pt;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                margin: 3px;\r\n");
      out.write("            }\r\n");
      out.write("            main{\r\n");
      out.write("                background: #fff;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            article li{\r\n");
      out.write("                color: #444;\r\n");
      out.write("                font-size: 15px;\r\n");
      out.write("                margin-left: 33px;\r\n");
      out.write("                line-height: 1.5;\r\n");
      out.write("                padding: 5px;\r\n");
      out.write("            }\r\n");
      out.write("            article h1,\r\n");
      out.write("            article h2,\r\n");
      out.write("            article h3,\r\n");
      out.write("            article h4,\r\n");
      out.write("            article p{\r\n");
      out.write("                padding: 14px;\r\n");
      out.write("                color: #333;\r\n");
      out.write("            }\r\n");
      out.write("            article p{\r\n");
      out.write("                font-size: 15px;\r\n");
      out.write("                line-height: 1.5;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            @media only screen and (min-width: 1280px){\r\n");
      out.write("                main{\r\n");
      out.write("                    max-width: 960px;\r\n");
      out.write("                    margin-left: auto;\r\n");
      out.write("                    margin-right: auto; \r\n");
      out.write("                    padding: 24px;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .set-overlayer,\r\n");
      out.write("            .set-glass,\r\n");
      out.write("            .set-sticky {\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                height: 45px;\r\n");
      out.write("                line-height: 45px;\r\n");
      out.write("                padding: 0 15px;\r\n");
      out.write("                color: #333;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("            }\r\n");
      out.write("            .set-overlayer:after,\r\n");
      out.write("            .set-glass:after,\r\n");
      out.write("            .to-active:after,\r\n");
      out.write("            .set-sticky:after {\r\n");
      out.write("                font-family: FontAwesome;\r\n");
      out.write("                font-size: 18pt;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("            }\r\n");
      out.write("            .set-overlayer:after,\r\n");
      out.write("            .set-glass:after,\r\n");
      out.write("            .set-sticky:after {\r\n");
      out.write("                content: \"\\f204\";\r\n");
      out.write("                transition: .6s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .to-active:after {\r\n");
      out.write("                content: \"\\f205\";\r\n");
      out.write("                color: #008080;\r\n");
      out.write("                transition: .6s;\r\n");
      out.write("            }\r\n");
      out.write("            .set-overlayer,\r\n");
      out.write("            .set-glass,\r\n");
      out.write("            .set-sticky,\r\n");
      out.write("            .source,\r\n");
      out.write("            .theme-tray {\r\n");
      out.write("                margin: 10px;\r\n");
      out.write("                background: #f2f2f2;\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("                border: 2px solid #f1f1f1;\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("            }\r\n");
      out.write("            /* Syntax Highlighter*/\r\n");
      out.write("\r\n");
      out.write("            pre.prettyprint {\r\n");
      out.write("                padding: 15px !important;\r\n");
      out.write("                margin: 10px;\r\n");
      out.write("                border: 0 !important;\r\n");
      out.write("                background: #f2f2f2;\r\n");
      out.write("                overflow: auto;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .source {\r\n");
      out.write("                white-space: pre;\r\n");
      out.write("                overflow: auto;\r\n");
      out.write("                max-height: 400px;\r\n");
      out.write("            }\r\n");
      out.write("            code{\r\n");
      out.write("                border:1px solid #ddd;\r\n");
      out.write("                padding: 2px;\r\n");
      out.write("                border-radius: 2px;\r\n");
      out.write("            }\r\n");
      out.write("            .sidebar{\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 100px 0 ;\r\n");
      out.write("            }\r\n");
      out.write("            .momo img{\r\n");
      out.write("                height: 20px;\r\n");
      out.write("                width: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .acb{\r\n");
      out.write("                float:right;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .pay .option-input {\r\n");
      out.write("                -webkit-appearance: none;\r\n");
      out.write("                -moz-appearance: none;\r\n");
      out.write("                -ms-appearance: none;\r\n");
      out.write("                -o-appearance: none;\r\n");
      out.write("                appearance: none;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                top: 13.33333px;\r\n");
      out.write("                right: 0;\r\n");
      out.write("                bottom: 0;\r\n");
      out.write("                left: 0;\r\n");
      out.write("                height: 20px;\r\n");
      out.write("                width: 20px;\r\n");
      out.write("                transition: all 0.15s ease-out 0s;\r\n");
      out.write("                background: #cbd1d8;\r\n");
      out.write("                border: none;\r\n");
      out.write("                color: #fff;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                margin-right: 0.5rem;\r\n");
      out.write("                outline: none;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                z-index: 1000;\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input:hover {\r\n");
      out.write("                background: #9faab7;\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input:checked {\r\n");
      out.write("                background: #40e0d0;\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input:checked::before {\r\n");
      out.write("                width: 40px;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                display:flex;\r\n");
      out.write("                content: '\\f00c';\r\n");
      out.write("                font-size: 25px;\r\n");
      out.write("                font-weight:bold;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                align-items:center;\r\n");
      out.write("                justify-content:center;\r\n");
      out.write("                font-family:'Font Awesome 5 Free';\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input:checked::after {\r\n");
      out.write("                -webkit-animation: click-wave 0.65s;\r\n");
      out.write("                -moz-animation: click-wave 0.65s;\r\n");
      out.write("                animation: click-wave 0.65s;\r\n");
      out.write("                background: #40e0d0;\r\n");
      out.write("                content: '';\r\n");
      out.write("                display: block;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                z-index: 100;\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input.radio {\r\n");
      out.write("                border-radius: 50%;\r\n");
      out.write("            }\r\n");
      out.write("            .pay .option-input.radio::after {\r\n");
      out.write("                border-radius: 50%;\r\n");
      out.write("            }\r\n");
      out.write("            .pay{\r\n");
      out.write("                margin-bottom: 30px;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"sidebar\"> \r\n");
      out.write("            <nav class=\"site-nav\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"menu-bg-wrap\">\r\n");
      out.write("                        <div class=\"site-navigation\">\r\n");
      out.write("\r\n");
      out.write("                            <a href=\"\" class=\"logo m-0 float-start\">Services</a>\r\n");
      out.write("\r\n");
      out.write("                            <ul class=\"js-clone-nav d-none d-lg-inline-block text-start site-menu float-end\">\r\n");
      out.write("                                <li class=\"active\"><a href=\"IndexServices\">Home</a></li>\r\n");
      out.write("                                <li class=\"has-children\">\r\n");
      out.write("                                    <a href=\"listServices.jsp\">Category</a>\r\n");
      out.write("                                    <ul class=\"dropdown\">\r\n");
      out.write("                                        <li><a href=\"#\">Dọn dẹp</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li><a href=\"listServices.jsp\">Support</a></li>\r\n");
      out.write("                                <li><a href=\"listServices.jsp\">About</a></li>\r\n");
      out.write("                                <li><a href=\"listServices.jsp\">Contact Us</a></li>\r\n");
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("                    \r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <a href=\"#\" class=\"burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none\" data-toggle=\"collapse\" data-target=\"#main-navbar\">\r\n");
      out.write("                                <span></span>\r\n");
      out.write("                            </a>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\"> \r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 order-md-2 mb-4\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        <li class=\"list-group-item d-flex justify-content-between\">\r\n");
      out.write("                            <span>Tổng </span>\r\n");
      out.write("                            <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("00 VND</strong>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul> \r\n");
      out.write("\r\n");
      out.write("                    <a class=\"btn btn-primary btn-lg btn-block\" href=\"ViewCart.jsp\">Quay lại giỏ hàng</a>\r\n");
      out.write("\r\n");
      out.write("                    <!--                    <form class=\"card p-2\">\r\n");
      out.write("                                            <div class=\"input-group\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" placeholder=\"Promo code\">\r\n");
      out.write("                                                <div class=\"input-group-append\">\r\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-secondary\">Redeem</button>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>-->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--        Thông tin người đặt dịch vụ-->\r\n");
      out.write("                <div class=\"col-md-8 order-md-1\">\r\n");
      out.write("                    <h4 class=\"mb-3\">Thông tin cá nhân</h4>\r\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label for=\"username\">Họ và tên</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LOGIN_USER.customerName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                            <div class=\"invalid-feedback\" style=\"width: 100%;\">\r\n");
      out.write("                                Valid first name is required.\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!--\r\n");
      out.write("                        \r\n");
      out.write("                                                <div class=\"mb-3\">\r\n");
      out.write("                                                    <label for=\"phone\">Số điện thoại</label>\r\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"address\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LOGIN_USER.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                                                    <div class=\"invalid-feedback\">\r\n");
      out.write("                                                        Please enter your shipping address.\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>-->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label for=\"email\">Email <span class=\"text-muted\">(Optional)</span></label>\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"you@example.com\">\r\n");
      out.write("                            <div class=\"invalid-feedback\">\r\n");
      out.write("                                Please enter a valid email address for shipping updates.\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <label>Địa chỉ và số điện thoại<span>*</span></label>\r\n");
      out.write("                        <select required name=\"addressPhone\" onchange=\"updateAddressPhone(this)\">\r\n");
      out.write("                            <option value=\"\">Chọn địa chỉ và số điện thoại</option>\r\n");
      out.write("                           ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        Hình thức thanh toán \r\n");
      out.write("                        <div class=\"pay\">\r\n");
      out.write("                            <input type=\"radio\" id=\"COD\" class=\"option-input radio\" name=\"Pay\" value=\"COD\"><label for=\"html\">Thanh toán khi hoàn thành</label>\r\n");
      out.write("<!--                            <div class=\"acb\">\r\n");
      out.write("                                <input value=\"ACB\" name=\"Pay\" type=\"radio\" class=\"option-input radio\"\r\n");
      out.write("                                       data-target=\"createp_account\" onchange=\"showCustomer(this.value)\"/>\r\n");
      out.write("                                <label class=\"\" data-toggle=\"collapse\" data-target=\"#collapsedefult\"\r\n");
      out.write("                                       aria-controls=\"collapsedefult\">ACB <img src=\"assets/img/icon/papyel.png\"\r\n");
      out.write("                                                                        alt=\"\"></label>\r\n");
      out.write("                            </div>-->\r\n");
      out.write("<!--                            <div id=\"txtHint\"></div>-->\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <button type=\"button\" onclick=\"window.location.href = 'addmoreaddress.jsp'\">Thêm địa chỉ và số điện thoại mới</button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"insert\">\r\n");
      out.write("                <a class=\"order\" href=\"\"><input class=\"btn btn-primary btn-lg btn-block\" type=\"submit\" name=\"action\" value=\"Payment\"/></a>\r\n");
      out.write("                <a class=\"cancel\" href=\"\"><input class=\"btn btn-primary btn-lg btn-block\" type=\"submit\" name=\"action\" value=\"Cancel\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form> \r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    function showCustomer(str) {\r\n");
      out.write("        var xhttp;\r\n");
      out.write("\r\n");
      out.write("        xhttp = new XMLHttpRequest();\r\n");
      out.write("        xhttp.onreadystatechange = function () {\r\n");
      out.write("            if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                document.getElementById(\"txtHint\").innerHTML = this.responseText;\r\n");
      out.write("            }\r\n");
      out.write("        };\r\n");
      out.write("        xhttp.open(\"GET\", \"payment.jsp\", true);\r\n");
      out.write("        xhttp.send();\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    function updateAddressPhone(selectElement) {\r\n");
      out.write("        var selectedValue = selectElement.value;\r\n");
      out.write("        var CustomerAddress = document.getElementById('CustomerAddress');\r\n");
      out.write("        var Phone = document.getElementById('Phone');\r\n");
      out.write("        var addressPhone = selectedValue.split('-');\r\n");
      out.write("\r\n");
      out.write("        CustomerAddress.value = decodeURIComponent(addressPhone[0]);\r\n");
      out.write("        Phone.value = decodeURIComponent(addressPhone[1]);\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("name");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LOGIN_USER.customerName}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty name}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <li class=\"dropdown\">\r\n");
        out.write("                                    <li class=\"has-children\">\r\n");
        out.write("                                        <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle user-action\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"35\" height=\"35\" fill=\"currentColor\" class=\"bi bi-person-circle\" viewBox=\"0 0 16 16\">\r\n");
        out.write("                                            <path d=\"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z\"/>\r\n");
        out.write("                                            <path fill-rule=\"evenodd\" d=\"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z\"/>\r\n");
        out.write("                                            </svg>  <b class=\"caret\"> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LOGIN_USER.customerName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" </b></a>\r\n");
        out.write("\r\n");
        out.write("                                        <ul class=\"dropdown\">\r\n");
        out.write("\r\n");
        out.write("                                            <li><a href=\"ViewCustomer\">Profile</a></li>\r\n");
        out.write("                                            <li><a href=\"#\">Setting</a></li>\r\n");
        out.write("                                            <li><a href=\"LogoutController\">Logout</a></li>\r\n");
        out.write("                                            <li><a href=\"MainController?action=History&status=1\">Lịch sử</a></li>\r\n");
        out.write("                                        </ul>\r\n");
        out.write("                                    </li> \r\n");
        out.write("\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("cart");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.CART_CHECKOUT}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.CART_CHECKOUT}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        ");
        if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("                        <h4 class=\"d-flex justify-content-between align-items-center mb-3\">\r\n");
        out.write("                            <span class=\"text-muted\">Thông tin dịch vụ</span>\r\n");
        out.write("                            <span class=\"badge badge-secondary badge-pill\">3</span>\r\n");
        out.write("                        </h4>\r\n");
        out.write("                        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_set_2.setVar("total");
    _jspx_th_c_set_2.setScope("session");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${0}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_forEach_0.setVar("tea");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.CART_CHECKOUT}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("counter");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            ");
          if (_jspx_meth_c_set_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                            <ul class=\"list-group mb-3\">\r\n");
          out.write("                                <li class=\"list-group-item d-flex justify-content-between lh-condensed\">\r\n");
          out.write("                                    <div>\r\n");
          out.write("                                        <h6 class=\"my-0\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tea.orderDServiceName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\r\n");
          out.write("                                        <small class=\"text-muted\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tea.serviceTime}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" h</small>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                    <span class=\"text-muted\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tea.orderDServicePrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("                                </li> \r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_3.setVar("total");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total + tea.orderDServicePrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listaddress}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("users");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.customerAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" - ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.customerAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" - ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                </option>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
