/*
 * LoadRunner Java script. (Build: 3020)
 * 
 * Script Description: 
 *                     
 */

import lrapi.*;
import com.globalegrow.app.gearbest.util.Authcode;
import org.json.*; 
import trim.trimstring;

public class Actions
{
        
	public int init() throws Throwable {
		return 0;
	}//end of init

        
	public int action() throws Throwable {
	  
            try{
		String boodhtml="";
		String Response_data="";
		String key="a784b4e023a4c3544a2af80e59ae55eb";
		String wid="";
		String boodhtml2="";
                 web.set_max_html_param_len("1024000");



		


		 /****cart_upload_addcart*****/


		 web.reg_save_param ("ResponseBody",
				     new String []{ 						      
					 "NOTFOUND=ERROR", 
					 "LB=", 
					 "RB=" , 
					 "Search=Body",
					 "LAST"} ); 
		boodhtml="{\"user_id\":\"<userid_test>\",\"add_cart\":[{\"rid\":\"55277744\",\"goods_id\":\"<goods_id>\",\"goods_number\":\"1\",\"wid\":\"21\",\"parent_id\":\"0\"},{\"rid\":\"55277744\",\"goods_id\":\"<goods_id2>\",\"goods_number\":\"1\",\"wid\":\"21\",\"parent_id\":\"0\"}],\"update_cart\":[],\"del_cart\":[],\"commparam\":\"ver=2.2.0&pf=android\"}";

		//System.out.println("boodhtml"+boodhtml);
		boodhtml=Authcode.Encode(boodhtml,key);

		//boodhtml2=Authcode.Decode(boodhtml,key);
		//System.out.println("boodhtml"+boodhtml);
		 lr.start_transaction("cart_upload_addcart");

		 web.custom_request("cart_upload", 
				    "URL= http://app.gearbest.com/api.php?mod=cart&act=cart_upload&isenc=1",                                   
				    new String[]{ 
				       "Method=POST",
					   "Body="+boodhtml, 					
					   "LAST"}); 

		 Response_data=Authcode.Decode(lr.eval_string("<ResponseBody>"), key);

		// System.out.println("Response_data"+Response_data);
		  if(Response_data.contains("\"add_cart\":{\"success\"")){

		      lr.end_transaction("cart_upload_addcart",lr.PASS);
		 }else{

		     lr.end_transaction("cart_upload_addcart",lr.FAIL);
		 }
		 
		 

		 JSONObject a = new JSONObject(Response_data);
		 String update_cart="";

		 update_cart= a.getString("add_cart");
		// System.out.println("update_cart===="+update_cart);
		 // System.out.println("os_warehouse"+warehouse);
		 //System.out.println("aaaaaaaaaaaaaaaaaaaaa"+a);

		// String b1 = update_cart.substring(1,update_cart.length()-1);
		 JSONObject b = new JSONObject(update_cart);

		 String success="";
		 success= b.getString("success");
	//	 System.out.println("success===="+success);


		 String b2 = success.substring(1,success.length()-1);
		 JSONObject c= new JSONObject(b2);

		 String rec_id="";
		 rec_id= c.getString("rec_id");
		// System.out.println("rec_id===="+rec_id);


		 lr.save_string(rec_id,"rec_id");
             //  System.out.println("rec_id===="+rec_id);

		 /****************cart_list*****************
		    url:   http://app.gearbest.com/api.php?mod=cart&act=cart_list&isenc=1
		    param: {"goods_id":"227453","user_id":"239918","wid":"21","commparam":"ver=2.0.0&pf=android"}
		    type:  post

		 

		 
                web.reg_save_param ("ResponseBody",
                                     new String []{ 						      
                                         "NOTFOUND=ERROR", 
                                         "LB=", 
                                         "RB=" , 
                                         "Search=Body",
                                         "LAST"} ); 
		boodhtml="{\"user_id\":\"<user_id>\",\"commparam\":\"ver=2.2.0&pf=android\"}";
		boodhtml=Authcode.Encode(boodhtml,key);

		//boodhtml2=Authcode.Decode(boodhtml,key);
		//System.out.println("boodhtml2"+boodhtml2);
		 lr.start_transaction("cart_list");

                 web.custom_request("cart_list", 
				    "URL=http://app.gearbest.com/api.php?mod=cart&act=cart_list&isenc=1",                                   
				    new String[]{ 
                                       "Method=POST",
                                           "Body="+boodhtml, 					
                                           "LAST"}); 
		
		 Response_data=Authcode.Decode(lr.eval_string("<ResponseBody>"), key);
		
		 System.out.println("Response_data"+Response_data);
		  if(Response_data.contains("cart_list")){

		      lr.end_transaction("cart_list",lr.PASS);
		 }else{

		     lr.end_transaction("cart_list",lr.FAIL);
		 }




                  /****************checkout_info*****************
		    url:   http://app.gearbest.com/api.php?mod=common&act=resend_email_valify&isenc=1
		    param: {"goods_id":"227453","user_id":"239918","wid":"21","commparam":"ver=2.0.0&pf=android"}
		    type:  post

		 */




              //   http://app-gearbest.com.a.s1.egomsl.com/api.php?mod=user&act=process_address&isenc=0




		  



		 
     /*       web.reg_save_param ("ResponseBody",
                                     new String []{ 						      
                                         "NOTFOUND=ERROR", 
                                         "LB=", 
                                         "RB=" , 
                                         "Search=Body",
                                         "LAST"} ); 
		boodhtml="{\"user_id\":\"<userid_test>\",\"select_goods\":\"<recid_test>\",\"pcode\":\"\",\"address_id\":\"<addressid_test>\",\"wid\":\"21\",\"commparam\":\"ver=2.2.0&pf=android\"}";

		System.out.println("boodhtml"+boodhtml);
		boodhtml=Authcode.Encode(boodhtml,key);

		//boodhtml2=Authcode.Decode(boodhtml,key);
		//System.out.println("boodhtml2"+boodhtml);
		 lr.start_transaction("checkout_info");

                 web.custom_request("checkout_info", 
				    "URL=http://app.gearbest.com/api.php?mod=cart&act=checkout_info&isenc=1",                                   
				    new String[]{ 
                                       "Method=POST",
                                           "Body="+boodhtml, 					
                                           "LAST"}); 
		
		 Response_data=Authcode.Decode(lr.eval_string("<ResponseBody>"), key);
		
		 System.out.println("Response_data"+Response_data);
		  if(Response_data.contains("new_shipping_list")){

		      lr.end_transaction("checkout_info",lr.PASS);
		 }else{

		     lr.end_transaction("checkout_info",lr.FAIL);
		 }


*/
		 

		

	   String  start="\"address_id\":\"";
	   String  end="\",\"user_id\"";

	   String address_id= trimstring.CutString(Response_data, start, end);
	   System.out.println("address_id====="+address_id);
	    lr.save_string(address_id,"address_id");


                  /****************create_order*****************
		    url:   http://app.gearbest.com/api.php?mod=common&act=resend_email_valify&isenc=1
		    param: {"goods_id":"227453","user_id":"239918","wid":"21","commparam":"ver=2.0.0&pf=android"}
		    type:  post
*/
		 

		 
                web.reg_save_param ("ResponseBody",
                                     new String []{ 						      
                                         "NOTFOUND=ERROR", 
                                         "LB=", 
                                         "RB=" , 
                                         "Search=Body",
                                         "LAST"} ); 
		//boodhtml="{\"user_id\":\"<user_id>\",\"shipping\":\"47\",\"country\":\"41\",\"payment\":\"PayPal\",\"select_item\":\""+rec_id+"\",\"address_id\":\""+address_id+"\",\"pcode\":\"\",\"offer_rate\":\"\",\"used_wallet\":\"0\",\"pay_password\":\"123456\",\"currency\":\"USD\",\"order_rate\":\"1\",\"wid\":\"21\",\"method_item_47\":\"105\",\"commparam\":\"ver=2.2.0&pf=android\"}";
		boodhtml="{\"user_id\":\"<userid_test>\",\"shipping\":\"47\",\"country\":\"41\",\"payment\":\"PayPal\",\"select_item\":\"<recid_test>\",\"select_goods\":\"<recid_test>\",\"address_id\":\"<addressid_test>\",\"pcode\":\"\",\"offer_rate\":\"\",\"used_wallet\":\"0\",\"pay_password\":\"123456\",\"currency\":\"USD\",\"order_rate\":\"1\",\"wid\":\"21\",\"method_item_47\":\"105\",\"commparam\":\"ver=2.2.0&pf=android\"}";

		System.out.println("boodhtml"+boodhtml);
		boodhtml=Authcode.Encode(boodhtml,key);

		//boodhtml2=Authcode.Decode(boodhtml,key);
		//System.out.println("boodhtml"+boodhtml);
		 lr.start_transaction("create_order");

                 web.custom_request("cart_list", 
				    "URL=http://app.gearbest.com/api.php?mod=cart&act=create_order&isenc=1",                                   
				    new String[]{ 
                                       "Method=POST",
                                           "Body="+boodhtml, 					
                                           "LAST"}); 
		
		 Response_data=Authcode.Decode(lr.eval_string("<ResponseBody>"), key);
		
		 System.out.println("Response_data"+Response_data);
		  if(Response_data.contains("_resultcode\":\"200\",\"order")){

		      lr.end_transaction("create_order",lr.PASS);
		 }else{

		     lr.end_transaction("create_order",lr.FAIL);
		 }

		 start="order_sn\":\"";
		 end="\",\"order_id\"";
		 String order_sn= trimstring.CutString(Response_data, start, end);

	  System.out.println("order_sn====="+order_sn);
	   lr.save_string(order_sn,"order_sn");
		




		   /****************create_order*****************
		    url:   http://app.gearbest.com/api.php?mod=common&act=resend_email_valify&isenc=1
		    param: {"goods_id":"227453","user_id":"239918","wid":"21","commparam":"ver=2.0.0&pf=android"}
		    type:  post
*/
		 

		 
      /*           web.reg_save_param ("ResponseBody",
                                     new String []{ 						      
                                         "NOTFOUND=ERROR", 
                                         "LB=", 
                                         "RB=" , 
                                         "Search=Body",
                                         "LAST"} ); 
		boodhtml="{\"user_id\":\"<userid_test>\",\"commparam\":\"ver=2.2.0&pf=android\",\"order_sn\":\""+order_sn+"\",\"successful\":\"1\"}";
		// boodhtml="{\"user_id\":\"4609092\",\"commparam\":\"ver=2.2.0&pf=android\",\"order_sn\":\"WB1612082006156536\",\"successful\":\"1\"}";
                //{"user_id":"4609092","commparam":"ver=2.2.0&pf=android","order_sn":"WB1612082006156536","successful":"1"} 
		System.out.println("boodhtml"+boodhtml);
		boodhtml=Authcode.Encode(boodhtml,key);

		//boodhtml2=Authcode.Decode(boodhtml,key);
		//System.out.println("boodhtml"+boodhtml);
		 lr.start_transaction("get_order_status");

                 web.custom_request("get_order_status", 
				    "URL=http://app.gearbest.com/api.php?mod=cart&act=get_order_status&isenc=1",                                   
				    new String[]{ 
                                       "Method=POST",
                                           "Body="+boodhtml, 					
                                           "LAST"}); 
		
		 Response_data=Authcode.Decode(lr.eval_string("<ResponseBody>"), key);
		
		 System.out.println("Response_data"+Response_data);
		  if(Response_data.contains("_resultcode\":\"200\",\"order")){

		      lr.end_transaction("get_order_status",lr.PASS);
		 }else{

		     lr.end_transaction("get_order_status",lr.FAIL);
		 }

*/

            }catch(Exception e){
                 e.printStackTrace();
                 return -1;
            }
		return 0;
	}//end of action


	public int end() throws Throwable {
		return 0;
	}//end of end
}

