//Donark Patel
//Lab 7
//Date: 4/4/2018
import java.util.Scanner; //Need for scanner
import java.io.*;


public class Lab7

    {
        public static void main (String [] args) throws IOException
        {
            //Variable
        int choose,x;
        String str,name,strExam1,strExam2,letter;
        String nameMax1,nameMax2,nameMin1,nameMin2,findName,exam1Str,exam2Str,exam1In,exam2In;
        float exam1,exam2,exam1total,exam2total,exam1avg,exam2avg,studentAvg,sum1,sum2,standardDiviation1,standardDiviation2,stdTestAvg;
		float maxTest1,maxTest2,minTest1,minTest2,difference;
		Boolean found;
		int ca,cb,cc,cd,cf;

        exam1total = 0;
        exam2total = 0;
        difference = 0;
        findName = "";


        //User input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter one of the following: \n (1) Class Average(Exam 1,Exam 2) \n (2) Student Average \n (3) " +
                          " Studard Deviations \n (4) Letter Grades \n (5) Minimum/Maximum \n (6) Locate grades with name \n " +
                "(7) Difference between tests >15% \n (8) Histogram \n (9) Update Data \n (10) Quit");
        choose = keyboard.nextInt();
        //File input
       File myFile=new File("input.txt");
       Scanner infile=new Scanner(myFile);
		//File Output
		PrintWriter outfile=new PrintWriter("mydata.txt");
        //*************
        // (1) Class Average
        //*************
        if (choose == 1)
        {
            System.out.println("*******Class Average*******\n");
            infile = new Scanner(myFile);
            infile.nextLine();
			x=1;
           while (x <= 25)
           {
            str=infile.nextLine();
            name=str.substring(0,10).trim();


            strExam1=str.substring(11,13).trim();
            exam1=Float.parseFloat(strExam1);

            strExam2=str.substring(14).trim();
            exam2=Float.parseFloat(strExam2);


            exam1total =exam1total+exam1;
            exam2total =exam2total+exam2;
            x = x+1;
           }
            exam1avg= exam1total/25;
            exam2avg=exam2total/25;

            System.out.println("Exam: 1 average: "+exam1avg);
            System.out.println("Exam: 1 average: "+exam2avg);
            infile.close();
        } //Class Average

		 //*************
		 // (2) Student Average
        //*************
		if (choose == 2){
			System.out.println("*******Student Average*******\n");
			System.out.printf("%10s %6s %6s %15s\n\n","Name","Exam 1","Exam 2","Average");
			infile = new Scanner(myFile);
            infile.nextLine();
            x=1;
            while(x <= 25){
				 str=infile.nextLine();
				 name=str.substring(0,10).trim();

				 strExam1=str.substring(11,13).trim();
				 exam1=Float.parseFloat(strExam1);

				 strExam2=str.substring(14).trim();
            	 exam2=Float.parseFloat(strExam2);
            	 studentAvg = (exam1 + exam2) / 2.0f;
            	 System.out.printf("%10s %6.2f %6.2f %15.2f\n",name,exam1,exam2,studentAvg);
            	 x++;
				}
				infile.close();
			} //Student Average

		//*************
		// (3) Standard Deviation
        //*************
		if (choose == 3){
			sum1=0;
			sum2=0;
			standardDiviation1=0;
			standardDiviation2=0;
			exam1=0;
			exam2=0;
			System.out.println("*******Standard Deviation*******\n");

						infile = new Scanner(myFile);
						infile.nextLine();
						x=1;
		  while(x <= 25){
						str=infile.nextLine();
						name=str.substring(0,10).trim();

						strExam1=str.substring(11,13).trim();
						exam1=Float.parseFloat(strExam1);

						strExam2=str.substring(14).trim();
						exam2=Float.parseFloat(strExam2);

						exam1total=exam1total+exam1;
						exam2total=exam2total+exam2;
						x++;
			}
			exam1avg=exam1total/25;
            exam2avg=exam2total/25;
						infile.close();
						infile = new Scanner(myFile);
            			infile.nextLine();
            x=1;

            while(x <= 25){
							str=infile.nextLine();
							name=str.substring(0,10).trim();

							strExam1=str.substring(11,13).trim();
						    exam1=Float.parseFloat(strExam1);

							strExam2=str.substring(14).trim();
							exam2=Float.parseFloat(strExam2);

						    sum1=(float)(sum1+Math.pow(exam1-exam1avg,2));
						    sum2=(float)(sum2+Math.pow(exam2-exam2avg,2));
						    x++;
			}
				standardDiviation1=(float)(Math.sqrt(sum1)/25);
				standardDiviation2=(float)(Math.sqrt(sum2)/25);

				System.out.printf("Standard Diviation for exam 1: %5.2f\n",standardDiviation1);
				System.out.printf("Standard Diviation for exam 2: %5.2f\n", standardDiviation2);
				infile.close();
		} //Standard Deviation


		//*************
		// (4) Letter Grades
        //*************
		if (choose == 4){
						System.out.println("*******Standard Deviation*******\n");
						infile = new Scanner(myFile);
						infile.nextLine();

						System.out.printf("%10s %6s %6s %15s\n\n","Name","Exam 1","Exam 2","Letter Grade");
 		for (x=1;x<=25;x++){

 						 str=infile.nextLine();
						 name=str.substring(0,10).trim();

						 strExam1=str.substring(11,13).trim();
						 exam1=Float.parseFloat(strExam1);

						 strExam2=str.substring(14).trim();
						 exam2=Float.parseFloat(strExam2);

 						studentAvg = (exam1 + exam2) / 2.0f;
						letter="";
 						if (studentAvg<=100 && studentAvg>=90)
 						letter="A";
 						else if (studentAvg>=80 && studentAvg<90)
 						letter="B";
 						else if (studentAvg>=70 && studentAvg<80)
 						letter="C";
 						else if (studentAvg>=60 && studentAvg<70)
 						letter="D";
 						else if (studentAvg<60)
 						letter="F";
						System.out.printf("%10s %6s %6s %10s\n",name,exam1,exam2,letter);
				}
				infile.close();
			} //Letter Grades

	   //*************
	   // (5) Max & min
       //*************
	   if (choose == 5){
					   System.out.println("*******Max and Min*******\n");
					   infile = new Scanner(myFile);
					   infile.nextLine();
					   x=1;
					   maxTest1=0;
					   maxTest2=0;
					   minTest1=100f;
					   minTest2=100f;
					   nameMax1="";
					   nameMax2="";
					   nameMin1="";
					   nameMin2="";
			while(x<=25){

					   str=infile.nextLine();
				       name=str.substring(0,10).trim();

					   strExam1=str.substring(11,13).trim();
					   exam1=Float.parseFloat(strExam1);

					   strExam2=str.substring(14).trim();
					   exam2=Float.parseFloat(strExam2);

				if (exam1>maxTest1)
					{
						maxTest1=exam1;
						nameMax1=name;
						}
				if (exam2>maxTest2)
					{
						maxTest2=exam2;
						nameMax2=name;
						}
				if (exam1<minTest1)
					{
						minTest1=exam1;
						nameMin1=name;
						}
				if (exam2<minTest2)
						{
						minTest2=exam2;
						nameMin2=name;
						}
						x++;
				}
				System.out.printf("%20s \n","Exam 1");
				System.out.printf("%20s \n","------");
				System.out.printf("%10s %20s %20s\n","Name","Maximum Score","Minumum Score");
				System.out.printf("%10s %15s \n",nameMax1,maxTest1);
				System.out.printf("%10s %35s \n",nameMin1,minTest1);

				System.out.printf("%20s \n","Exam 2");
				System.out.printf("%20s \n","------");
				System.out.printf("%10s %20s %20s\n","Name","Maximum Score","Minumum Score");
				System.out.printf("%10s %15s \n",nameMax2,maxTest2);
				System.out.printf("%10s %35s \n",nameMin2,minTest2);
			infile.close();
		} //Max & min


		//*************
	   // (6) Find by name
       //*************
	   if (choose == 6){
						System.out.println("*******Find by name*******\n");


						System.out.println("Enter name to find the exam scores");
						Scanner kb = new Scanner(System.in);
						findName = kb.nextLine();

						found=false;
					   infile = new Scanner(myFile);
					   infile.nextLine();
					   x=1;
			while(x<=25){

					   str=infile.nextLine();
					   name=str.substring(0,10).trim();

					   strExam1=str.substring(11,13).trim();
					   exam1=Float.parseFloat(strExam1);

					   strExam2=str.substring(14).trim();
					   exam2=Float.parseFloat(strExam2);
					   if(name.equalsIgnoreCase(findName)){
						   System.out.printf("\n%5s %7s %6s \n\n","Name","Exam 1","Exam 2");
						   System.out.printf("%5s %6.2f %6.2f \n\n",name,exam1,exam2);
						   found=true;


						   }
						   x++;
					   }
					   if (!found)
					   System.out.println("Name not found");
					   infile.close();

						} //Find by name


		//*************
	   // (7) Difference
       //*************
	   if (choose == 7)
	   {
      				   System.out.println("*******Difference*******\n");
					   found=false;
					   infile = new Scanner(myFile);
					   infile.nextLine();
					   x=1;
			while(infile.hasNext())
				{

					str=infile.nextLine();
					name=str.substring(0,10).trim();

					strExam1=str.substring(11,13).trim();
					exam1=Float.parseFloat(strExam1);

					strExam2=str.substring(14).trim();
					exam2=Float.parseFloat(strExam2);

					if (exam1>exam2)
					difference=(exam1-exam2);
					else if (exam1<exam2)
					difference=(exam2-exam1);

					if (difference>15)
					{

						System.out.printf("%9s %5s %5s \n\n", "Name", "Exam 1" ,"Exam 2");
						System.out.printf("%9s %5.1f %5.1f\n", name ,exam1, exam2);
           				found=true;

						}
					}
					if (!found)
					System.out.println("No student found");
					infile.close();

		} //Difference


 		//**************
 		// (8)Histogram
 		//**************

		if (choose==8)
		      {
				System.out.println("******Histogram**************\n");
		        ca=0;cb=0;cc=0;cd=0;cf=0;
		        infile=new Scanner(myFile);
		        infile.nextLine();
		        name="";
		        str="";

		        for(x=1;x<=25;x++)
		        {
		          str=infile.nextLine();
		          name=str.substring(0,9).trim();
		          exam1In=str.substring(9,14).trim();
		          exam1=Float.parseFloat(exam1In);
		          exam2In=str.substring(14).trim();
		          exam2=Float.parseFloat(exam2In);
		          stdTestAvg=(exam1+exam2)/2.0f;

		          if (stdTestAvg<=100 && stdTestAvg>=90)
		            ca++;
		          else if (stdTestAvg>=80 && stdTestAvg<90)
		            cb++;

		          else if (stdTestAvg>=70 && stdTestAvg<80)
		            cc++;
		          else if (stdTestAvg>=60 && stdTestAvg<60)
		            cd++;
		          else if (stdTestAvg<60)
		            cf++;

		        }
		        System.out.println("Total number of grades are:- \nA = "+ ca+"\nB = " + cb+"\nC = " +cc+"\nD = " +cd+"\nF = " +cf);
		        infile.close();
      }//histogram

		//**************
 		// (9)Update
 		//**************
		 if (choose==9)
		      {
				  System.out.println("********Update**************\n");
		        x=1;

		        System.out.println("Enter name to Update result");
		        Scanner kb2= new Scanner(System.in);
				findName = kb2.nextLine();
		        infile=new Scanner(myFile);
		        infile.nextLine();
		        String newTest1,newTest2;
		        float enterTest1,enterTest2;
		        found=false;
		        while(x<=25)
		        {
		          str=infile.nextLine();
		          name=str.substring(0,9).trim();
		          exam1In=str.substring(10,14).trim();
		          exam1=Float.parseFloat(exam1In);
		          exam2In=str.substring(14).trim();
		          exam2=Float.parseFloat(exam2In);
		          if(x==1)
		          {
		            outfile.printf("%9s %5s %5s\n", "name" ,"exam1", "exam2");
		            /*System.out.printf("%9s %5s %5s\n", "name" ,"exam1", "exam2");*/

		          }

		          if(name.equalsIgnoreCase( findName ))

		          {
		           	System.out.println("Enter exam1 " );
		            Scanner kb = new Scanner(System.in);
						newTest1 = kb.nextLine();
		            enterTest1=Float.parseFloat(newTest1);
		            exam1=enterTest1;
		            System.out.println("Enter exam2 " );
		            newTest2 = kb.nextLine();
		            enterTest2=Float.parseFloat(newTest2);
		            exam2=enterTest2;
		            found=true;
		          }

		          System.out.printf("%9s %5.1f %5.1f\n", name ,exam1, exam2);
		          outfile.printf("%9s %5.1f %5.1f\n", name ,exam1, exam2);
		          x++;
		        }
		        if (!found)
		          System.out.println("Name not found");
		        infile.close();

      }//Update

        //**************
	   	// (9)Quit
 		//**************
		if (choose==10)
		System.out.println("\nQuit");
        }


        }



























