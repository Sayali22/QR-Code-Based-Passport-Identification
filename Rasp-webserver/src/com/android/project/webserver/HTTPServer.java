package com.android.project.webserver;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPServer extends MyHTTP {

	public static boolean isChecked = true;
	boolean flag=false;
	public boolean isLogin = false;
	String innerFolderName = File.separator;
	private final String TAG = "com.example.httpserver.HelloServer";

	private final String HEADER = "<h2><center>Project Name- </center></h2>";

	private final String MENU = "<div data-role=\"content\" data-theme=\"b\" id=\"content\">"
			+

			"<a href=\"/HTTPServer/registration\"><img src=\"/HTTPServer/files/images/usericon.png\" height=\"70\" width=\"80\"></a>"+
			"&nbsp;"+
			"&nbsp;"+
			"&nbsp;"+
			"&nbsp;"
			+ "<a href=\"/HTTPServer/index.html\"><img src=\"/HTTPServer/files/images/logoutImage.jpg\" height=\"70\" width=\"80\"></a>"
			+ "</div>";

	private String message = "<html>"
			+ "<head> 	<link rel=\"stylesheet\"  href=\"/HTTPServer/files/css/jquery.mobile-1.2.0.css\" />"
			+ "<script src=\"/HTTPServer/files/js/jquery.js\"></script>"
			+ "<script src=\"/HTTPServer/files/js/jquery.mobile.min.js\"></script>"
			+ "<body>" +

			"<div data-role=\"page\" data-theme=\"b\">" +

			"<div data-role=\"content\" data-theme=\"b\" id=\"content\">"
			+ "</div>"
			+ HEADER
			+ "<div id=\"SelectClientType\">"
			+

			"<div style=\"float:right; width=49%;\" align=\"right\">"
			+ "<form name=\"frmNewClient\" action=\"/HTTPServer/validateLogin\" method=\"GET\">"
			+ "<table border=\"0\"> 	   "
			+ "<tr>"
			+ "<td>User Name:</td>"
			+ "<td><input type=\"text\" id=\"txtUserName\" name=\"username\" placeholder=\"User Name\" required=\"required\"/></td>"
			+ "</tr>"
			+ "<tr>"
			+ "<td>Password:</td>"
			+ "<td><input type=\"password\" id=\"txtPassword\" name=\"password\" placeholder=\"Password\" required=\"required\"/></td>"
			+ "</tr>"
			+ "<tr>"
			+ "<td>"
			+

			"<input type=\"submit\" id=\"btnSubmit\" value=\"Submit\"/></td>"
			+ "<td><input type=\"button\" id=\"btnCancel\" value=\"Cancel\"/></td>"
			+ "</tr>"
			+ "</table>"
			+ "</form>"
			+ "</div>"
			+ "</div>"

			+ "</div>" + "</body>" + "</html>";

	public HTTPServer() {
		super(8088);
	}

	@Override
	public Response serve(IHTTPSession session) {
		Method method = session.getMethod();
		String uri = session.getUri();
		System.out.println(method + " '" + uri + "' ");
		System.out.println( method + " '" + uri + "' ");
		String[] uriArray = uri.split("/");
		System.out.println( "uri array length :" + uriArray.length);
		System.out.println( "after array length");
		if (uri.equalsIgnoreCase("/HTTPServer/")
				|| uri.equalsIgnoreCase("/HTTPServer")
				|| uri.equalsIgnoreCase("/HTTPServer/index.html")
				|| uri.equalsIgnoreCase("/HelloServer/index.htm")) {

			isLogin = false;
			System.out.println( "set to false islogin == false");
			System.out.println( "inside  HTTPServer");
			String msg = "<html>"
					+ "<head> 	<link rel=\"stylesheet\"  href=\"/HTTPServer/files/css/jquery.mobile-1.2.0.css\" />"
					+ "<script src=\"/HTTPServer/files/js/jquery.js\"></script>"
					+ "<script src=\"/HTTPServer/files/js/jquery.mobile.min.js\"></script>"
					+ "<body>" + "<div data-role=\"page\" data-theme=\"b\">" +

					"<div data-role=\"content\" data-theme=\"b\" id=\"content\">"
					+ HEADER
					+ "<div id=\"SelectClientType\" align=\"center\">"
					+ "<form name=\"frmNewClient\" action=\"/HTTPServer/validateLogin\" method=\"GET\">"
					+ "<table border=\"0\"> 	   "
					+ "<tr>"
					+ "<td>User Name:</td>"
					+ "<td><input type=\"text\" id=\"txtUserName\" name=\"username\" placeholder=\"User Name\" required=\"required\"/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>Password:</td>"
					+ "<td><input type=\"password\" id=\"txtPassword\" name=\"password\" placeholder=\"Password\" required=\"required\"/></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>"
					+

					"<input type=\"submit\" id=\"btnSubmit\" value=\"Submit\"/></td>"
					+ "<td><input type=\"button\" id=\"btnCancel\" value=\"Cancel\"/></td>"
					+ "</tr>"
					+ "</table>"
					+ "</form>"
					+ "</div>"
					+ "</div>"
					+ "</div>" + "</body>" + "</html>";

			return new MyHTTP.Response(msg);
		}

		else if (uri.equalsIgnoreCase("/HTTPServer/validateLogin")) {
			Map<String, String> parms = session.getParms();
			System.out.println( "username :" + parms.get("username") + " password:"
					+ parms.get("password"));
			String msg = "";
			if (parms.get("username").equalsIgnoreCase("admin")
					&& parms.get("password").equalsIgnoreCase("admin")) {
				isLogin = true;
				System.out.println( "set to false islogin == false");
				msg = "<html>"
						+ "<head> 	<link rel=\"stylesheet\"  href=\"/HTTPServer/files/css/jquery.mobile-1.2.0.css\" />"
						+ "<script src=\"/HTTPServer/files/js/jquery.js\"></script>"
						+ "<script src=\"/HTTPServer/files/js/jquery.mobile.min.js\"></script>"
						+

						"<body>"
						+ "<div data-role=\"content\" data-theme=\"b\" id=\"content\">"
						+ "welcome to http server" + "</div>"
						+ "<div data-role=\"page\" data-theme=\"b\">" + HEADER
						+ "</br>" + "</br>" + "</br>" + MENU
						+

						// "<embed src=\"/HTTPServer/files/videos/Video1.mp4\" type=\"application/x-mplayer2\" pluginspage=\"http://www.microsoft.com/Windows/MediaPlayer/\" name=\"mediaplayer1\" ShowStatusBar=\"true\" EnableContextMenu=\"false\" width=\"700\" height=\"500\" autostart=\"false\" loop=\"false\" align=\"middle\" volume=\"60\" ></embed>"+
						"<div id=\"SelectClientType\" align=\"center\">"
						+ "</div>"  + "</div>" + "</body>" + "</html>";

			}

			else {
				isLogin = false;
				msg = "<html>"
						+ "<head> 	<link rel=\"stylesheet\"  href=\"/HTTPServer/files/css/jquery.mobile-1.2.0.css\" />"
						+ "<script src=\"/HTTPServer/files/js/jquery.js\"></script>"
						+ "<script src=\"/HTTPServer/files/js/jquery.mobile.min.js\"></script>"
						+ "<body>"
						+ "<div data-role=\"page\" data-theme=\"b\">" +

						"<div data-role=\"content\" data-theme=\"b\" id=\"content\">"
						+ HEADER
						+

						"<div id=\"SelectClientType\" align=\"center\">"
						+ "<form name=\"frmNewClient\" action=\"/HTTPServer/validateLogin\" method=\"GET\">"
						+ "<table border=\"0\"> 	   "
						+ "<tr>"
						+ "<td>User Name:</td>"
						+ "<td><input type=\"text\" id=\"txtUserName\" name=\"username\" placeholder=\"User Name\" required=\"required\"/></td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>Password:</td>"
						+ "<td><input type=\"password\" id=\"txtPassword\" name=\"password\" placeholder=\"Password\" required=\"required\"/></td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>"
						+

						"<input type=\"submit\" id=\"btnSubmit\" value=\"Submit\"/></td>"
						+ "<td><input type=\"button\" id=\"btnCancel\" value=\"Cancel\"/></td>"
						+ "</tr>"
						+ "</table>"
						+ "</form>"
						+ "</div>"
						+ "</div>"  + "</div>" + "</body>" + "</html>";
			}

			return new MyHTTP.Response(msg);

		}	


		else if (uri.startsWith("/HTTPServer/files")) {

			System.out.println( "in files");
			InputStream fin = null;
			try {
				fin = new FileInputStream(new File("D:" +uri));
				return new Response(Response.Status.OK, MIME_PLAINTEXT, fin);

			} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(HTTPServer.class.getName()).log(Level.SEVERE,
						null, ex);
			} finally {
				try {
					// fin.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					Logger.getLogger(HTTPServer.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		else if(uri.startsWith("/HTTPServer/registration"))
		{

			String msg1 = "<html>"+
					"<head> 	<link rel=\"stylesheet\"  href=\"/HTTPServer/files/css/jquery.mobile-1.2.0.css\" />"+
					"<script src=\"/HTTPServer/files/js/jquery.js\"></script>"+
					"<script src=\"/HTTPServer/files/js/jquery.mobile.min.js\"></script>"+
					"<body>"+
					"<div data-role=\"page\" data-theme=\"b\">"+
					"<div data-role=\"content\" data-theme=\"b\" id=\"content\">"+
				
					"<div id=\"SelectClientType\" align=\"center\">"+
					"<form action=\"/HTTPServer/validateLogin\">"+
					"<table border=\"0\">" +
					"<tr>"+
					"<td> First name:</td><br>"+
					"<td> <input type=\"text\" name=\"firstname\" value=\"\"></td>"+
					" <br>"+
					"</tr>"+
					"<tr>"+
					" <td>Last name:<br></td>"+
					" <td><input type=\"text\" name=\"lastname\" value=\"\"></td>"+
					"<br>"+
					"</tr>"+
					"<tr>"+
					"<td>Mobile no:<br></td>"+
					"<td> <input type=\"text\" name=\"Mobileno\" value=\"\"></td>"+
					" <br>"+
					"</tr>"+
					"<tr>"+
					"<td> E-mail Id:<br></td>"+
					"<td><input type=\"text\" name=\"email\" value=\"\"></td>"+
					" <br>"+
					"</tr>"+
					"<tr>"+
					"<td>Address:<br></td>"+
					"<td><input type=\"text\" name=\"address\" value=\"\"><td>"+
					"<br>"+
					"</tr>"+
					"<tr>"+
					"<td>Username:<br></td>"+
					"<td><input type=\"text\" name=\"username\" value=\"\"></td>"+
					"<br>"+
					"</tr>"+
					"<tr>"+
					"<td>Password:<br></td>"+
					"<td><input type=\"text\" name=\"password\" value=\"\"></td>"+
					"<br>"+
					"</tr>"+
					"<tr>"+
					"<br>"+
					"<td><input type=\"submit\" value=\"AddUser\"></td>"+
					"</tr>"+
					"</form>"+
					"</body>"+
					"</html>";


			return new MyHTTP.Response(msg1);


		}


		else {
			
			String msg = "<html><body><h1>Hello server</h1>\n";

			msg += "</body></html>\n";

			return new MyHTTP.Response(msg);
		}
		return null;
	}

}
