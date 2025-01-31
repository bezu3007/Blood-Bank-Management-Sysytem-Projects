#include <iostream>
#include <string.h>
#include<iomanip>
#include <fstream>
using namespace std;

//fstream doners_file;
struct Person
{
    string  name;
    int id;
    string gender;
    string date;
    int age;
    string blood_group;
    string phone_no;//+251
    string email;
};


Person add(Person &p)
{
            cout<<"\n\t\t\t Enter Name:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.name;

            cout<<"\n\t\t\t Enter Id:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.id;

            mark_c:
            cout<<"\n\t\t\t Enter Gender:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.gender;
           if(p.gender .compare("M")==0||p.gender.compare("F")==0 )
           {cout<<"";}
           else{
                cout<<"Invalid input please enter again"<<endl;
               goto mark_c;}



            mark_a:
            cout<<"\n\t\t\t Enter Age:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.age;
            if(p.age<18 || p.age>60)
            {
               cout<<"Your Age Is Not Allowed To Donate Blood"<<endl ;

               goto mark_a;
            }
           mark_b:
            cout<<"\n\t\t\t Enter Blood Group:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.blood_group;
           if(p.blood_group.compare("A+")==0 || p.blood_group.compare("A-")==0 ||p.blood_group.compare("B+")==0||p.blood_group.compare("B-")==0||
              p.blood_group.compare("AB+")==0||p.blood_group.compare("AB-")==0||p.blood_group.compare("O+")==0||p.blood_group.compare("O-")==0)
            {cout<<"";}

            else{
                cout<<"Invalid blood type please enter again"<<endl;
               goto mark_b;
            }

            cout<<"\n\t\t\t Enter Phone No.:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.phone_no;

             cout<<"\n\t\t\t Enter Date of the Donation :"<<endl;
            cout<<" \t\t\t ";
            cin>>p.date;

            cout<<"\n\t\t\t Enter E-mail:"<<endl;
            cout<<" \t\t\t ";
            cin>>p.email;

            //system("cls");
            cout<<"\n\t Your data has been successfully added to  the our database."<<endl;

            return p;
}

void add_new(Person);
void blood_store();
void request_blood();
void Search();
void display_store();
void display();

    int main(){
Person p;




        m:{

        cout<<"\n\t\t===========================================";
        cout<<"\n\t\t|  Blood Bank Management System   |"<<endl;
        cout<<"\t\t===========================================";
        cout<<"\n\t \t \t ::Enter Your Choice::"<<endl;
        cout<<"\n\t\t\tTo Add New Data \t(1)\n\t\t\tTo View List Of Donar   (2)\n\t\t\tTo Search Donar \t(3)\n\t\t\tTo Store \t\t(4) \n\t\t\tTo Exit \t(5)"<<endl;
        cout<<"\t\t\t: ";
        int n;
        cin>>n;
        switch (n)
        {

        case 1:
        {add_new(add(p));goto m; break;}


        case 2:
        {display();  goto m;  break;}
        case 3:
        {Search();goto m; break;}
        case 4:
        {blood_store();goto m; break;}

        case 5:
        {
        	cout<<"Thanks for visiting"<<endl;break;}


        default:
        {
            system("cls");
            cout<<"\a\aPlease Enter your choice Correctly:\a\a"<<endl;
             goto m;break;}

        }
        }
return 0;

}
void add_new(Person x){
        ofstream file("doners.txt",ios::app);//write
            if(file.is_open())
            {

               file<<'\n'<<x.id<<'\t'<<x.name
               <<'\t'<<x.gender<<'\t'<<x.age
               <<'\t'<<x.blood_group<<'\t'<<x.phone_no
               <<'\t'<<x.email<<'\t'<<x.date;

            }
            file.close();
            system("PAUSE");}


void display(){
    string a,b,c,d, e,f,g,h;

 ifstream doners_file("doners.txt");//read
            if(doners_file.is_open())
            {
                cout<<"open\n";
                //string line;
                while(doners_file>>a>>b>>c>>d>>e>>f>>g>>h)
        {

                cout<<setw(5)<<a
                <<setw(15)<<b
                <<setw(15)<<c
                <<setw(15)<<d
                <<setw(15)<<e
                <<setw(25)<<f
                <<setw(25)<<g
                <<setw(15)<<h<<endl;
        }

            }
doners_file.close();
system("PAUSE");
        }

void blood_store()
{
    char n;
    Person p;
     cout<<"What do you want to do?"<<endl;
     cout<<"1, To Display Blood Packet"<<endl;
     cout<<"2, To Request Blood"<<endl;
     cout<<"3, To main menu"<<endl;
     cin>>n;

    switch(n)
    {
        case '1':{display_store(); blood_store(); break;}

        case '2':{request_blood(); blood_store(); break;}

        case '3':{  break;}
        default: cout<<"enter correct option \n"; blood_store();  break;
    }


}

void Search()
{
    string Search1,a,b,c,d,e,f,g,h;
   // string line;

    ifstream doner_file("doners.txt");
    cout<<"Enter the id you want to search"<<endl;
    cin >>Search1;

    bool found = false;
    if(doner_file.is_open())
    {
        while(doner_file>>a>>b>>c>>d>>e>>f>>g>>h)
        {

            //if ( ( offset = line.find(Search1,0) ) != string::nopos )
            if(Search1.compare(a)==0)
            {
                cout<<"the record has been founded \t"<<Search1<<endl;
                cout<<a<<'\t'<<b<<'\t'<<c<<'\t'<<d<<'\t'<<e<<'\t'<<f<<'\t'<<g<<'\t'<<h;
                found=true;
            }
        }
        doner_file.close();
        if(!found)cout<<"file not found \n";
    }


    else cout<<"could not open file"<<endl;

    system("PAUSE");
}
void display_store()
    {

    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;

    string q,w,r,t, y,u,i,o;

    ifstream dfile("doners.txt");
    while(dfile>>q>>w>>r>>t >>u>>y>>i>>o){

    if(u == "A+"){a++;}
    else if(u=="A-"){b++;}
    else if(u == "B+"){c++;}
    else if(u=="B-"){d++;}
    else if(u == "AB+"){e++;}
    else if(u == "AB-"){f++;}
    else if(u == "O+"){g++;}
    else if(u == "O-"){h++;}
    else cout<<"none";

    }
    dfile.close();
    cout<<"Total Blood Packet are "<<a+b+c+d+e+f+g+h<<endl;
    cout<<"blood Type"<<setw(20)<<"blood packet"<<endl;
    cout<<"A+ "<<setw(20)<<a<<endl;
    cout<<"A- "<<setw(20)<<b<<endl;
    cout<<"B+ "<<setw(20)<<c<<endl;
    cout<<"B- "<<setw(20)<<d<<endl;
    cout<<"AB+ "<<setw(20)<<e<<endl;
    cout<<"AB- "<<setw(20)<<f<<endl;
    cout<<"O+ "<<setw(20)<<g<<endl;
    cout<<"O-"<<setw(20)<<h<<endl;

    }


void request_blood()
{   int pnum;

    cout<<"How many blood Packet do you want: ";
    cin>>pnum;

    string a,b,c,d, e,f,g,h;
    ifstream r_file("doners.txt");
    ofstream w_file("temp.txt");
    bool found =false;
    for(int i=0;i<pnum;i++){
    string bg;
    cout<<"Enter The Blood you Want: "<<endl;
    cin>>bg;
    while(r_file>>a>>b>>c>>d >>e>>f>>g>>h)
        {
        if(bg.compare(e)==0&&!found){cout<<"request accepted \n";
        found=true;}
        else w_file<<a<<'\t'<<b<<'\t'<<c<<'\t'<<d  <<'\t'<<e<<'\t'<<f<<'\t'<<g<<'\t'<<h<<endl;

        }
    if(!found)cout<<"we are out of bloodtype "<<bg<<" try another type"<<endl;

    w_file.close();
    r_file.close();

    remove("doners.txt");
    rename("temp.txt","doners.txt");


    }

}
