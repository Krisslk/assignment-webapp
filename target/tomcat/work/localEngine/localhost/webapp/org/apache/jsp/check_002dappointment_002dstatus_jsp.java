package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class check_002dappointment_002dstatus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <title>Welcome to ABC Laboratories</title>\n");
      out.write("  <!-- Bootstrap CSS -->\n");
      out.write("  <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("  <style>\n");
      out.write("    body {\n");
      out.write("      background-image: url('https://img.freepik.com/free-photo/medicine-blue-background-flat-lay_23-2149341573.jpg'); /* Replace 'background.jpg' with the path to your image */\n");
      out.write("      background-size: cover;\n");
      out.write("      background-position: center;\n");
      out.write("      height: 100vh;\n");
      out.write("      margin: 0;\n");
      out.write("      padding: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .title-container {\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      height: 15%;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div class=\"title-container\">\n");
      out.write("    <h1 style=\"color: white;margin-top: 30%;\" >Welcome to ABC Laboratories</h1>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"text-center\">\n");
      out.write("    <form method=\"post\" action=\"check-appointment-status\">\n");
      out.write("      <input  style=\"margin-top: 15%; width: 20%;\" type=\"text\" name=\"NICNo\">\n");
      out.write("      <button type=\"submit\" class=\"btn btn-primary\">Check</button>\t\t\t\n");
      out.write("    </form>\t\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
