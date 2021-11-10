package com.gmmr.rms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gmmr.rms.controller.RoommateController;
import com.gmmr.rms.model.RMSResponseModel;
import com.gmmr.rms.model.Roommate;

public class AppTest {
	
	private static final Logger LOG = LogManager.getLogger(AppTest.class);
	
	public static void main(String[] args) throws Exception
	{
		LOG.info("Welcome to ROOM MANAGEMENT SYSTEM");
		boolean flag=true;
		RMSResponseModel response;
		RoommateController rmtController = new RoommateController();
		System.out.println();
		System.out.println("****************************************************");
		System.out.println(":: Welcome to ROOM MANAGEMENT SYSTEM ::");
		System.out.println("****************************************************");
		System.out.println();
		while(flag)
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println(":: MENU ::");
			System.out.println("-----------------------------------------------------");
			System.out.println("1)Add Roommate 2)Edit Roommate 3)Delete Roommate\n4)Search Roommate 5)Display Roommate Details 6)Exit");
			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.print("Enter ur choice: ");
			char ch = br.readLine().charAt(0);
			switch(ch)
			{
				
				case '1':
				  String s=" ";
				  do
				  {	
					try {
						System.out.println("Please Enter Details to Create New Roommate");
						System.out.println();
						System.out.print("Name: ");
						String nm=br.readLine();
						System.out.print("Address: ");
						String ad=br.readLine();
						System.out.print("Mobile: ");
						String mb=br.readLine();
						System.out.print("Date Of Joining (in year-month-day): ");
						LocalDate date = null;
						String tdate = br.readLine();
						if(StringUtils.isNotBlank(tdate)) {
							date = LocalDate.parse(tdate);
						}
						Roommate rmt=new Roommate();
						rmt.setName(nm);
						rmt.setAddress(ad);
						rmt.setMobile(mb);
						rmt.setDateOfJoining(date);
						response = rmtController.addRoommate(rmt);
						System.out.println(response.getResult());
						System.out.println();
						System.out.println("Do u want to continue(y to proceed): ");
						s=br.readLine();
					}
					catch (Exception e) {
						System.err.println("Exception: "+ e.getMessage() +", please try again with proper inputs.");
						System.out.println();
					}
				  }while(s.equalsIgnoreCase("y"));
					break;
				
				case '2':
				  String s2= " ";
				  do
				  {
					 try {
						 	System.out.println("Edit Existig Roommate Details");
							System.out.println();
							System.out.print("Enter Roommate ID to edit: ");
							int no=Integer.parseInt(br.readLine());
							Roommate rmt=new Roommate();
							rmt.setNo(no);
							response = rmtController.searchRoommate(no);
							if(response.isStatus()) {
								Roommate oldRmt = (Roommate) response.getResponseObject();
								Roommate rmtEdit = new Roommate();
								System.out.print("Enter Name: ");
								String nm=br.readLine();
								System.out.print("Enter Address: ");
								String ad=br.readLine();
								System.out.print("Enter Mobile: ");
								String mb=br.readLine();
								System.out.print("Enter Date Of Joining (in year-month-day): ");
								LocalDate date = null;
								if(StringUtils.isNotBlank(br.readLine())) {
									date = LocalDate.parse(br.readLine());
								}
								
								rmtEdit.setNo(oldRmt.getNo());
								if(StringUtils.isNotBlank(nm)) {
									rmtEdit.setName(nm);
								}
								else {
									rmtEdit.setName(oldRmt.getName());
								}
								if(StringUtils.isNotBlank(ad)) {
									rmtEdit.setAddress(ad);
								}
								else {
									rmtEdit.setAddress(oldRmt.getAddress());
								}
								if(StringUtils.isNotBlank(mb)) {
									rmtEdit.setMobile(mb);
								}
								else {
									rmtEdit.setMobile(oldRmt.getMobile());
								}
								if(date != null) {
									rmtEdit.setDateOfJoining(date);
								}
								else {
									rmtEdit.setDateOfJoining(oldRmt.getDateOfJoining());
								}
								response = rmtController.editRoommate(rmtEdit);
							}
							System.out.println(response.getResult());
							System.out.println();
							System.out.println("Do u want to continue(y to proceed): ");
							s2=br.readLine();
					 }
					 catch (Exception e) {
						 System.err.println("Exception: "+ e.getMessage() +", please try again with proper inputs.");
						 System.out.println();
					 }
				  }while(s2.equalsIgnoreCase("y"));
					break;
				
				case '3':
				  do
				  {	
					System.out.println("Deleteing Roommate Details");
					System.out.println();
					System.out.print("Enter number of the roommate: ");
					int no=Integer.parseInt(br.readLine());
					response = rmtController.deleteRoommate(no);
					System.out.println(response.getResult());
					System.out.println();
					System.out.println("Do u want to continue(y to proceed): ");
					s=br.readLine();
				  }while(s.equalsIgnoreCase("y"));
					break;
				
				case '4':
				  do
				  {	
					System.out.println("Searching Roommate Details");
					System.out.println();
					System.out.print("Enter Roommate ID number: ");
					int no=Integer.parseInt(br.readLine());
					response = rmtController.searchRoommate(no);
					System.out.println(response.getResponseObject());
					System.out.println();
					System.out.println("Do u want to continue (y to proceed): ");
					s=br.readLine();
				  }while(s.equalsIgnoreCase("y"));
					break;
				
				case '5':
					System.out.println("Displaying All Roommate Details");
					System.out.println();
					List<Roommate> rmtList = (List<Roommate>) rmtController.getAllRoommates().getResponseObject();
					System.out.println("ID\t\tName\t\tAddress\t\tMobile\t\tDate of Joining");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					for (Roommate rmt : rmtList) {
						System.out.println(rmt.getNo()+ "\t\t" + rmt.getName() + "\t\t" + rmt.getAddress() + "\t\t" + rmt.getMobile() + "\t\t" + rmt.getDateOfJoining());
					}
					if(rmtList != null && rmtList.isEmpty()) {
						System.out.println("No Data Available");
					}
					System.out.println();
					break;
				
				case  '6':
					System.out.println("THANK U. VISIT AGAIN");
					flag=false;
					break;
				default:
					System.out.println("Invalid option.Try again");
			}
		}
	}
}
