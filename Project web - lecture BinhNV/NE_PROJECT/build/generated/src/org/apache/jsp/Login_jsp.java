package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"/CSS/login.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                position: relative;\n");
      out.write("                background-image: url(\"IMAGE/background.png\");\n");
      out.write("            }\n");
      out.write("            a,\n");
      out.write("            a:active,\n");
      out.write("            a:visited {\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p {\n");
      out.write("                text-align: center;\n");
      out.write("                font-weight: bold;\n");
      out.write("                font-size: 28px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            a {\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tile {\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .textfield {\n");
      out.write("                border-radius: 5px;\n");
      out.write("                outline: none;\n");
      out.write("                padding: 5px;\n");
      out.write("                font-size: 18px;\n");
      out.write("                width: 250px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-middle {\n");
      out.write("                border-radius: 10px;\n");
      out.write("                position: fixed;\n");
      out.write("                top: 40%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(-49%, -49%);\n");
      out.write("                padding: 0 50px 20px 50px;\n");
      out.write("                background-color: wheat;\n");
      out.write("                box-shadow: 2px 7px 7px #666666;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .button-shadow {\n");
      out.write("                border-radius: 5px;\n");
      out.write("                padding: 10px 20px 10px 20px;\n");
      out.write("                box-shadow: 1px 2px 1px 1px #666666;\n");
      out.write("            }\n");
      out.write("            .login{\n");
      out.write("                background-color: deepskyblue;\n");
      out.write("                color: white;\n");
      out.write("                margin-left: 40px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .register{\n");
      out.write("                color: white;\n");
      out.write("                margin-left: 10px;\n");
      out.write("                background-color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"login-middle\">\n");
      out.write("            <p >LOGIN</p>\n");
      out.write("            <form action=\"Login\" method=\"POST\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th></th>\n");
      out.write("                        <td><input class=\"textfield\" type=\"text\" name=\"username\" placeholder=\"Username\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th></th>\n");
      out.write("                        <td><input class=\"textfield\" type=\"password\" name=\"password\" placeholder=\"Password\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"checkbox\" name=\"remember\" value=\"remember\" checked>Remember\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <button class=\"button-shadow login\" name=\"login\" value=\"login\">Login</button>\n");
      out.write("                            <button class=\"button-shadow register\" name=\"login\" value=\"register\">Register</button>\n");
      out.write("                        </td> \n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
}
