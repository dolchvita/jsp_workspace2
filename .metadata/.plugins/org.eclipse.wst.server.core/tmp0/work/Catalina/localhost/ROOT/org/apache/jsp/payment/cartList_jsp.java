/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-29 23:57:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.jspshop.domain.Member;
import org.apache.ibatis.session.SqlSession;
import com.jspshop.mybatis.MybatisConfig;
import com.jspshop.domain.Category;
import java.util.List;
import com.jspshop.repository.CategoryDAO;

public final class cartList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	CategoryDAO categoryDAO=new CategoryDAO();

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("/inc/footer_link.jsp", Long.valueOf(1674886866000L));
    _jspx_dependants.put("/inc/insta.jsp", Long.valueOf(1674886773000L));
    _jspx_dependants.put("/inc/footer.jsp", Long.valueOf(1674886833000L));
    _jspx_dependants.put("/inc/search.jsp", Long.valueOf(1674690521000L));
    _jspx_dependants.put("/inc/header_section.jsp", Long.valueOf(1674987249000L));
    _jspx_dependants.put("/inc/preloder.jsp", Long.valueOf(1674690416000L));
    _jspx_dependants.put("/inc/header.jsp", Long.valueOf(1674886667000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.jspshop.mybatis.MybatisConfig");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.jspshop.repository.CategoryDAO");
    _jspx_imports_classes.add("com.jspshop.domain.Category");
    _jspx_imports_classes.add("org.apache.ibatis.session.SqlSession");
    _jspx_imports_classes.add("com.jspshop.domain.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"description\" content=\"Ashion Template\">\n");
      out.write("    <meta name=\"keywords\" content=\"Ashion, unica, creative, html\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>쇼핑몰 예제</title>\n");
      out.write("\n");
      out.write("    <!-- Google Font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\"\n");
      out.write("    rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Css Styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/magnific-popup.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\" type=\"text/css\">");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- Page Preloder -->\n");
      out.write("	");
      out.write("\n");
      out.write("    <div id=\"preloder\">\n");
      out.write("        <div class=\"loader\"></div>\n");
      out.write("    </div>");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Header Section Begin -->\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');


	List<Category> category_list=categoryDAO.selectAll();

      out.write("\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xl-3 col-lg-2\">\n");
      out.write("                    <div class=\"header__logo\">\n");
      out.write("                        <a href=\"/\"><img src=\"/img/logo.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xl-6 col-lg-7\">\n");
      out.write("                    <nav class=\"header__menu\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li class=\"active\"><a href=\"./index.html\">Home</a></li>\n");
      out.write("	                        ");
for(int i=0; i<category_list.size(); i++){ 
      out.write("\n");
      out.write("	                        ");
Category category=category_list.get(i); 
      out.write("\n");
      out.write("                            <li><a href=\"#\">");
      out.print(category.getCategory_name() );
      out.write("</a></li>\n");
      out.write("                            ");
} 
      out.write("\n");
      out.write("                            <li><a href=\"/shop.jsp\">Shop</a></li>\n");
      out.write("                            <li><a href=\"#\">Pages</a>\n");
      out.write("                                <ul class=\"dropdown\">\n");
      out.write("                                    <li><a href=\"./product-details.html\">Product Details</a></li>\n");
      out.write("                                    <li><a href=\"./shop-cart.html\">Shop Cart</a></li>\n");
      out.write("                                    <li><a href=\"./checkout.html\">Checkout</a></li>\n");
      out.write("                                    <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                            <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3\">\n");
      out.write("                    <div class=\"header__right\">\n");
      out.write("                        <div class=\"header__right__auth\">\n");
      out.write("                        ");
if(session.getAttribute("member")==null){ 
      out.write("\n");
      out.write("                            <a href=\"/member/loginform.jsp\">Login</a>\n");
      out.write("                            <a href=\"/member/joinform.jsp\">Register</a>  \n");
      out.write("                                                  \n");
      out.write("                        ");
}else{ 
      out.write("\n");
      out.write("                        ");
Member member=(Member)session.getAttribute("member"); 
      out.write("\n");
      out.write("                        \n");
      out.write("                            <a href=\"/member/logout.jsp\">Logout</a>\n");
      out.write("                            <a href=\"#\">");
      out.print(member.getId() );
      out.write("</a>                                                \n");
      out.write("                        ");
} 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <ul class=\"header__right__widget\">\n");
      out.write("                            <li><span class=\"icon_search search-switch\"></span></li>\n");
      out.write("                            <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\n");
      out.write("                                <div class=\"tip\">2</div>\n");
      out.write("                            </a></li>\n");
      out.write("                            <li><a href=\"/payment/cartList.jsp\"><span class=\"icon_bag_alt\"></span>\n");
      out.write("                                <div class=\"tip\">2</div>\n");
      out.write("                            </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"canvas__open\">\n");
      out.write("                <i class=\"fa fa-bars\"></i>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>");
      out.write("\n");
      out.write("    <!-- Header Section End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Shop Cart Section Begin -->\n");
      out.write("    <section class=\"shop-cart spad\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"shop__cart__table\">\n");
      out.write("                        <table>\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Product</th>\n");
      out.write("                                    <th>Price</th>\n");
      out.write("                                    <th>Quantity</th>\n");
      out.write("                                    <th>Total</th>\n");
      out.write("                                    <th></th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"cart__product__item\">\n");
      out.write("                                        <img src=\"img/shop-cart/cp-1.jpg\" alt=\"\">\n");
      out.write("                                        <div class=\"cart__product__item__title\">\n");
      out.write("                                            <h6>Chain bucket bag</h6>\n");
      out.write("                                            <div class=\"rating\">\n");
      out.write("                                                <i class=\"fa fa-star\"></i>\n");
      out.write("                                                <i class=\"fa fa-star\"></i>\n");
      out.write("                                                <i class=\"fa fa-star\"></i>\n");
      out.write("                                                <i class=\"fa fa-star\"></i>\n");
      out.write("                                                <i class=\"fa fa-star\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"cart__price\">$ 150.0</td>\n");
      out.write("                                    <td class=\"cart__quantity\">\n");
      out.write("                                        <div class=\"pro-qty\">\n");
      out.write("                                            <input type=\"text\" value=\"1\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"cart__total\">$ 300.0</td>\n");
      out.write("                                    <td class=\"cart__close\"><span class=\"icon_close\"></span></td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("                    <div class=\"cart__btn\">\n");
      out.write("                        <a href=\"#\">Continue Shopping</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
      out.write("                    <div class=\"cart__btn update__btn\">\n");
      out.write("                        <a href=\"#\"><span class=\"icon_loading\"></span> Update cart</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"discount__content\">\n");
      out.write("                        <h6>Discount codes</h6>\n");
      out.write("                        <form action=\"#\">\n");
      out.write("                            <input type=\"text\" placeholder=\"Enter your coupon code\">\n");
      out.write("                            <button type=\"submit\" class=\"site-btn\">Apply</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 offset-lg-2\">\n");
      out.write("                    <div class=\"cart__total__procced\">\n");
      out.write("                        <h6>Cart total</h6>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>Subtotal <span>$ 750.0</span></li>\n");
      out.write("                            <li>Total <span>$ 750.0</span></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"#\" class=\"primary-btn\">Proceed to checkout</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- Shop Cart Section End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("	<!-- Instagram Begin -->\n");
      out.write("	");
      out.write("\n");
      out.write("<div class=\"instagram\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-1.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-2.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-3.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-4.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-5.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/img/instagram/insta-6.jpg\">\n");
      out.write("                    <div class=\"instagram__text\">\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("	<!-- Instagram End -->\n");
      out.write("	\n");
      out.write("	<!-- Footer Section Begin -->\n");
      out.write("	");
      out.write("\n");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-4 col-md-6 col-sm-7\">\n");
      out.write("                <div class=\"footer__about\">\n");
      out.write("                    <div class=\"footer__logo\">\n");
      out.write("                        <a href=\"./index.html\"><img src=\"/img/logo.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt\n");
      out.write("                    cilisis.</p>\n");
      out.write("                    <div class=\"footer__payment\">\n");
      out.write("                        <a href=\"#\"><img src=\"/img/payment/payment-1.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/img/payment/payment-2.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/img/payment/payment-3.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/img/payment/payment-4.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"#\"><img src=\"/img/payment/payment-5.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-5\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Quick links</h6>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">About</a></li>\n");
      out.write("                        <li><a href=\"#\">Blogs</a></li>\n");
      out.write("                        <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        <li><a href=\"#\">FAQ</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-4\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Account</h6>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">My Account</a></li>\n");
      out.write("                        <li><a href=\"#\">Orders Tracking</a></li>\n");
      out.write("                        <li><a href=\"#\">Checkout</a></li>\n");
      out.write("                        <li><a href=\"#\">Wishlist</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-4 col-md-8 col-sm-8\">\n");
      out.write("                <div class=\"footer__newslatter\">\n");
      out.write("                    <h6>NEWSLETTER</h6>\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <input type=\"text\" placeholder=\"Email\">\n");
      out.write("                        <button type=\"submit\" class=\"site-btn\">Subscribe</button>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"footer__social\">\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-youtube-play\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                <div class=\"footer__copyright__text\">\n");
      out.write("                    <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a></p>\n");
      out.write("                </div>\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("    ");
      out.write("\n");
      out.write("	<!-- Footer Section End -->\n");
      out.write("	\n");
      out.write("	<!-- Search Begin -->\n");
      out.write("	");
      out.write("\n");
      out.write("<div class=\"search-model\">\n");
      out.write("    <div class=\"h-100 d-flex align-items-center justify-content-center\">\n");
      out.write("        <div class=\"search-close-switch\">+</div>\n");
      out.write("        <form class=\"search-model-form\">\n");
      out.write("            <input type=\"text\" id=\"search-input\" placeholder=\"Search here.....\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("	<!-- Search End -->\n");
      out.write("	\n");
      out.write("	<!-- Js Plugins -->\n");
      out.write("	");
      out.write("\n");
      out.write("<script src=\"/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<script src=\"/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery-ui.min.js\"></script>\n");
      out.write("<script src=\"/js/mixitup.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery.countdown.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery.slicknav.js\"></script>\n");
      out.write("<script src=\"/js/owl.carousel.min.js\"></script>\n");
      out.write("<script src=\"/js/jquery.nicescroll.min.js\"></script>\n");
      out.write("<script src=\"/js/main.js\"></script>");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
