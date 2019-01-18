package com.cignex.constant;

public class Constant {
	
	
	public static final String UPLOAD_DIRECTORY="G:\\SprinBoot\\MovieTicketBooking\\src\\main\\webapp\\WEB-INF\\view\\upload\\";
	
	/******************************************
	 * Database Table name Constant
	 *****************************************************/
	public static final String ADMIN_TABLE="admin_master";
	public static final String USER_TABLE="user_master";
	public static final String MOVIE_TABLE="movie_master";
	public static final String SCREENLIST_TABLE="screen_master";
	public static final String BOOKING_TABLE="booking_master";
	public static final String MOVIE_SHOW_TABLE="movie_show_master";
	
	/******************************************
	 * Main Request Controller Constant
	 *****************************************************/
	public static final String ADMIN_CONTROLLER_REQUEST = "/admin";
	public static final String BOOK_TICKET_CONTROLLER_REQUEST = "/bookTicket";
	public static final String MOVIE_CONTROLLER_REQUEST = "/movie";
	public static final String SCREEN_LIST_CONTROLLER_REQUEST = "/screenList";
	public static final String USER_CONTROLLER_REQUEST = "/user";

	/******************************************
	 * 
	 * Request Controller Constant
	 * 
	 *****************************************************/
	public static final String HOME_PAGE_REQUEST = "/home";
	public static final String REGISTER_REQUEST = "/register";
	public static final String SAVE_REQUEST = "/save";
	public static final String GET_ALL_DATA_REQUEST = "/list";
	public static final String GET_BY_ID_REQUEST = "/get";
	public static final String DELETE_BY_ID_REQUEST = "/delete/{id}";

	/******************************************
	 * 
	 * Constant for retruning jsp file for admin
	 * 
	 *****************************************************/
	public static final String ADMIN_HOME_PAGE_JSP="admin/home";
	public static final String ADMIN_REGISTER_JSP = "/admin/register";
	public static final String UPDATE_ADMIN_JSP = "/admin/update";
	public static final String LIST_ADMIN_JSP = "/admin/allAdmin";
	public static final String REDIRECT_ADMIN = "redirct:/admin/allAdmin";
	/******************************************
	 * 
	 * Constant for retruning jsp file for user
	 * 
	 *****************************************************/
	public static final String USER_REGISTER_JSP = "/user/register";
	public static final String UPDATE_USER_JSP = "/user/update";
	public static final String LIST_USER_JSP = "/user/allUser";
	public static final String REDIRECT_USER = "redirct:/user/allUser";
	/******************************************
	 * 
	 * Constant for retruning jsp file for bookticket
	 * 
	 *****************************************************/
	public static final String BOOK_TICKET_JSP = "/booking/book";
	public static final String UPDATE_BOOK_TICKET_JSP = "/booking/update";
	public static final String LIST_BOOKED_TICKET_JSP = "/booking/allBookedTicket";
	public static final String REDIRECT_BOOKEDTICKET = "redirct:/booking/allBookedTicket";

	/******************************************
	 * 
	 * Constant for retruning jsp file for movie
	 * 
	 *****************************************************/
	public static final String MOVIE_REGISTER_JSP = "/movie/register";
	public static final String UPDATE_MOVIE_JSP = "/movie/update";
	public static final String LIST_MOVIE_JSP = "/movie/allMovie";
	public static final String REDIRECT_MOVIE = "redirect:/movie/list";
	/******************************************
	 * 
	 * Constant for retruning jsp file for screenlist
	 * 
	 *****************************************************/

	public static final String SCREEN_REGISTER_JSP = "/screen/register";
	public static final String UPDATE_SCREEN_JSP = "/screen/update";
	public static final String LIST_SCREEN_JSP = "/screen/allScreen";
	public static final String REDIRECT_SCREEN_LIST = "redirct:/screen/allScreen";
	
	/******************************************
	 * 
	 * Constant for retruning jsp file for show
	 * 
	 *****************************************************/
	public static final String SHOW_REGISTER_JSP = "/show/register";
	public static final String UPDATE_SHOW_JSP = "/show/update";
	public static final String LIST_SHOW_JSP = "/show/allShow";
	public static final String REDIRECT_SHOW = "redirct:/show/allShow";

}
