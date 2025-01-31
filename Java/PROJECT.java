import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PROJECT {
//    Reminder ////////
// should also include weight validation.
//     ///////////
    public static void main(String[] args) {
        projectDemo proj1 = new projectDemo();
        proj1.createNewFile();
        proj1.readMainFile();
        proj1.readStoreFile();
        // for (int i = 0; i < 1; i++)
        // proj1.Update_store(i);
        proj1.mainMenu();
    }
}

class projectDemo {
    ArrayList<Donor> donors = new ArrayList<Donor>();
    public int Aplus = 0, Aminus = 0, Bplus = 0, Bminus = 0, ABplus = 0, ABminus = 0,
            Oplus = 0,
            Ominus = 0,
            total = 0;

    void emptyFile() {
        try {
            FileWriter myWriter = new FileWriter("mainfile.txt", true);
            myWriter.write("Name age Sex ID Blood_type Phone_number Email Donation_date\n");
            myWriter.write("____________________________________________________________\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void createNewFile() {
        try {
            File myObj = new File("mainfile.txt");
            File myObj2 = new File("Blood_store.txt");
            boolean b1 = (myObj.createNewFile());
            boolean b2 = (myObj2.createNewFile());
        } catch (IOException e) {
            System.out.println("An error occurred while creating file.");
            e.printStackTrace();
        }
    }

    void readStoreFile() {
        try {
            File myObj2 = new File("Blood_store.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNext()) {
                String str;
                str = myReader2.nextLine();
                str = myReader2.nextLine();
                str = myReader2.next();
                Aplus = myReader2.nextInt();
                str = myReader2.next();
                Aminus = myReader2.nextInt();
                str = myReader2.next();
                Bplus = myReader2.nextInt();
                str = myReader2.next();
                Bminus = myReader2.nextInt();
                str = myReader2.next();
                ABplus = myReader2.nextInt();
                str = myReader2.next();
                ABminus = myReader2.nextInt();
                str = myReader2.next();
                Oplus = myReader2.nextInt();
                str = myReader2.next();
                Ominus = myReader2.nextInt();
                total = Aplus + Aminus + Bplus + Bminus + ABplus + ABminus + Oplus + Ominus;
            }
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    void readMainFile() {
        try {
            File myObj = new File("mainfile.txt");
            Scanner myReader = new Scanner(myObj);
            if (!myReader.hasNext()) {
                emptyFile();
            }
            int i = 0;
            while (myReader.hasNext()) {
                Donor don1 = new Donor();
                donors.add(don1);
                if (i == 0) {
                    String str = myReader.nextLine();
                    str = myReader.nextLine();
                }
                String data = myReader.next();
                donors.get(i).setName(data);
                int data_int = myReader.nextInt();
                donors.get(i).setAge(data_int);
                data = myReader.next();
                donors.get(i).setSex(data);
                data = myReader.next();
                donors.get(i).setId(data);
                data = myReader.next();
                donors.get(i).setBloodType(data);
                data = myReader.next();
                donors.get(i).setPhone_no(data);
                data = myReader.next();
                donors.get(i).setEmail(data);
                data = myReader.nextLine();
                donors.get(i).setDate(data);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void mainMenu() {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\t=====================================");
        System.out.println("\t||  Blood Bank Management System   ||");
        System.out.println("\t=====================================");
        System.out.println("1. Add Donors");
        System.out.println("2. Display donors");
        System.out.println("3. Search donor");
        System.out.println("4. To blood store");
        System.out.println("5. Exit");
        System.out.print("Enter Your choice: ");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                int num;
                System.out.print("Enter the number of donors you want to add :");
                Scanner input1 = new Scanner(System.in);
                num = input1.nextInt();
                for (int i = 0; i < num; ++i) {
                    System.out.println("For donor " + (i + 1) + ":-");
                    Donor tempDonor = new Donor();
                    donors.add(tempDonor);
                    addDonors(tempDonor);
                }

                mainMenu();
                break;
            case 2:
                if (donors.size() == 0) {
                    System.out.println("There is no any data.Please add data first.");
                    mainMenu();
                } else {
                    display();
                    mainMenu();
                }
                break;
            case 3:
                if (donors.size() == 0) {
                    System.out.println("There is no any data.Please add data first.");
                    mainMenu();
                } else {
                    Search();
                    mainMenu();
                }
                break;
            case 4:
                if (donors.size() == 0) {
                    System.out.println("There is no any data.Please add data first.");
                    mainMenu();
                } else {
                    blood_store();
                    mainMenu();
                }
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Please enter a valid input.");
                mainMenu();
        }
    }

    class Donor {
        private String name;
        private String id;
        private String sex;
        private String date;
        private int age;
        private String blood_type;
        private String phone_no;
        private String email;

        public void setName(String name1) {
            name = name1;
        }

        public void setSex(String sex1) {
            sex = sex1;
        }

        public void setId(String id1) {
            id = id1;
        }

        public void setBloodType(String blood_type1) {
            blood_type = blood_type1;
        }

        public void setAge(int age1) {
            age = age1;
        }

        public void setDate(String date1) {
            date = date1;
        }

        public void setPhone_no(String phone1) {
            phone_no = phone1;
        }

        public void setEmail(String email1) {
            email = email1;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public String getId() {
            return id;
        }

        public String getBloodType() {
            return blood_type;
        }

        public int getAge() {
            return age;
        }

        public String getDate() {
            return date;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public String getEmail() {
            return email;
        }

    }

    void addDonors(Donor donor1) {
        try {
            FileWriter myWriter = new FileWriter("mainfile.txt", true);
            String name = "";
            String id = "";
            String sex = "";
            int age = 0;
            String blood_type = "";
            String phone_no = "";
            String email = "";

            Scanner x = new Scanner(System.in);
            System.out.print("Enter Donor's name: ");
            name = x.nextLine();
            donor1.setName(name);
            myWriter.write(name + " ");
            int labelAge = 0;
            do {
                System.out.print("Enter Donor's age: ");
                age = x.nextInt();
                if (age < 18 || age > 60) {
                    System.out.println("Blood donation is not allowed at this age.Please enter a valid age.");
                    labelAge = 1;
                } else
                    labelAge = 0;
            } while (labelAge == 1);
            x.nextLine();// to move the cursor to next line
            donor1.setAge(age);
            myWriter.write(age + " ");

            int labelSex = 0;
            do {
                System.out.print("Enter Donor's sex: ");
                sex = x.nextLine().toUpperCase();
                if (sex.equals("M") || sex.equals("F") || sex.equals("MALE") || sex.equals("FEMALE"))
                    labelSex = 0;
                else {
                    System.out.println("Invalid input.Try again.");
                    labelSex = 1;
                }
            } while (labelSex == 1);
            donor1.setSex(sex);
            myWriter.write(sex + " ");
            id = "bb" + String.format("%04d", donors.size());
            donor1.setId(id);
            myWriter.write(id + " ");
            int labelBloodType = 0;
            do {
                System.out.print("Enter Donor's blood type: ");
                blood_type = x.nextLine().toUpperCase();
                if (blood_type.equals("A+") || blood_type.equals("A-") || blood_type.equals("B+")
                        || blood_type.equals("B-")
                        || blood_type.equals("AB+") || blood_type.equals("AB-") || blood_type.equals("O+")
                        || blood_type.equals("O-"))
                    labelBloodType = 0;
                else {
                    System.out.println("Please enter a valid blood group.");
                    labelBloodType = 1;
                }
            } while (labelBloodType == 1);
            donor1.setBloodType(blood_type);
            myWriter.write(blood_type + " ");

            System.out.print("Enter Donor's phone number: ");
            phone_no = x.nextLine();
            donor1.setPhone_no(phone_no);
            myWriter.write(phone_no + " ");
            int labelEmail = 0;
            do {
                System.out.print("Enter Donor's email: ");
                email = x.nextLine();
                if (email.endsWith("@gmail.com"))
                    labelEmail = 0;
                else {
                    System.out.println("Please enter a valid email.");
                    labelEmail = 1;
                }
            } while (labelEmail == 1);
            donor1.setEmail(email);
            myWriter.write(email + " ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            donor1.setDate(dtf.format(now));
            myWriter.write(dtf.format(now) + "\n");
            System.out.println("\nYour data has been saved successfully.\n");
            Update_store(donors.size() - 1);
            Storefile();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void Storefile() {
        try {
            FileWriter myWriter2 = new FileWriter("Blood_store.txt");
            myWriter2.write("Total blood packet: " + total + "\n");
            myWriter2.write("Blood type\tNumber of blood packets:" + "\n");
            myWriter2.write("A+\t\t\t\t" + Aplus + "\n");
            myWriter2.write("A-\t\t\t\t" + Aminus + "\n");
            myWriter2.write("B+\t\t\t\t" + Bplus + "\n");
            myWriter2.write("B-\t\t\t\t" + Bminus + "\n");
            myWriter2.write("AB+\t\t\t\t" + ABplus + "\n");
            myWriter2.write("AB-\t\t\t\t" + ABminus + "\n");
            myWriter2.write("O+\t\t\t\t" + Oplus + "\n");
            myWriter2.write("O-\t\t\t\t" + Ominus + "\n");
            myWriter2.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    void display() {
        System.out.println(String.format("%-15s", "Name") + String.format("%-10s", "age")
                + String.format("%-10s", "Sex") + String.format("%-10s", "ID") + String.format("%-17s", "Blood type")
                + String.format("%-20s", "Phone number") + String.format("%-20s", "Email") + "Donation date");

        for (int i = 0; i < donors.size(); ++i) {
            System.out.println(String.format("%-15s", donors.get(i).getName())
                    + String.format("%-10s", donors.get(i).getAge())
                    + String.format("%-10s", donors.get(i).getSex()) + String.format("%-10s", donors.get(i).getId())
                    + String.format("%-17s", donors.get(i).getBloodType())
                    + String.format("%-20s", donors.get(i).getPhone_no())
                    + String.format("%-20s", donors.get(i).getEmail()) + donors.get(i).getDate());
        }
    }

    void Search() {
        Scanner scan = new Scanner(System.in);
        String key;
        System.out.print("Enter the name of the donor you want to search: ");
        key = scan.nextLine();
        int found = 0, index = 0;
        for (int i = 0; i < donors.size(); ++i) {
            if (donors.get(i).name.toLowerCase().equals(key.toLowerCase())) {
                index = i;
                found = 1;
                break;
            }
        }
        if (found == 1) {
            System.out.println("Record found.");
            System.out.println("Name\tage\tSex\tID\tBlood type\tPhone number\tEmail\tDonation date");
            System.out
                    .println(donors.get(index).name + "\t" + donors.get(index).age + "\t" + donors.get(index).sex + "\t"
                            + donors.get(index).id + "\t" + donors.get(index).blood_type + "\t" + "\t"
                            + donors.get(index).phone_no + "\t"
                            + donors.get(index).email + "\t" + donors.get(index).date);
        } else {
            System.out.println("Record not found.");
        }

    }

    void blood_store() {
        Scanner scan2 = new Scanner(System.in);
        int choice2;
        System.out.println("What do you want to do?");
        System.out.println("1, To Display Blood Packet");
        System.out.println("2, To Request Blood");
        System.out.println("3, To main menu");
        System.out.print("Choice:");
        choice2 = scan2.nextInt();

        switch (choice2) {
            case 1: {
                display_store();
                blood_store();
                break;
            }

            case 2: {
                request_blood();
                blood_store();
                break;
            }

            case 3: {
                mainMenu();
                break;
            }
            default:
                System.out.println("enter correct option");
                blood_store();
                break;
        }
    }

    void Update_store(int i) {
        if (donors.get(i).blood_type.equals("A+"))
            Aplus++;
        else if (donors.get(i).blood_type.equals("A-"))
            Aminus++;
        else if (donors.get(i).blood_type.equals("B+"))
            Bplus++;
        else if (donors.get(i).blood_type.equals("B-"))
            Bminus++;
        else if (donors.get(i).blood_type.equals("AB+"))
            ABplus++;
        else if (donors.get(i).blood_type.equals("AB-"))
            ABminus++;
        else if (donors.get(i).blood_type.equals("O+"))
            Oplus++;
        else if (donors.get(i).blood_type.equals("O-"))
            Ominus++;
        total = Aplus + Aminus + Bplus + Bminus + ABplus + ABminus + Oplus + Ominus;
    }

    void display_store() {
        System.out.println("Total blood packet: " + total);
        System.out.println("Blood type\tNumber of blood packets");
        System.out.println("A+\t\t" + Aplus);
        System.out.println("A-\t\t" + Aminus);
        System.out.println("B+\t\t" + Bplus);
        System.out.println("B-\t\t" + Bminus);
        System.out.println("AB+\t\t" + ABplus);
        System.out.println("AB-\t\t" + ABminus);
        System.out.println("O+\t\t" + Oplus);
        System.out.println("O-\t\t" + Ominus);
    }

    void request_blood() {
        int packetNnum;
        String blood_type;
        Scanner scan3 = new Scanner(System.in);
        System.out.print("How many blood Packet do you want: ");
        packetNnum = scan3.nextInt();
        // scan3.nextLine();
        int labelB_TYPE = 0;
        int trial_counter = 0;
        do {
            labelB_TYPE = 0;
            System.out.print("Enter the blood type you want: ");
            blood_type = scan3.next().toUpperCase();
            switch (blood_type) {
                case "A+":
                    if (packetNnum <= Aplus) {
                        System.out.println("Request accepted.");
                        Aplus = Aplus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "A-":
                    if (packetNnum <= Aminus) {
                        System.out.println("Request accepted.");
                        Aminus = Aminus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "B+":
                    if (packetNnum <= Bplus) {
                        System.out.println("Request accepted.");
                        Bplus = Bplus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "B-":
                    if (packetNnum <= Bminus) {
                        System.out.println("Request accepted.");
                        Bminus = Bminus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "AB+":
                    if (packetNnum <= ABplus) {
                        System.out.println("Request accepted.");
                        ABplus = ABplus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "AB-":
                    if (packetNnum <= ABminus) {
                        System.out.println("Request accepted.");
                        ABminus = ABminus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "O+":
                    if (packetNnum <= Oplus) {
                        System.out.println("Request accepted.");
                        Oplus = Oplus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                case "O-":
                    if (packetNnum <= Ominus) {
                        System.out.println("Request accepted.");
                        Ominus = Ominus - packetNnum;
                        labelB_TYPE = 2;
                    } else {
                        System.out.println("We are run out of blood type " + blood_type + ".Try another type.");
                        labelB_TYPE = 1;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid blood type.");
                    labelB_TYPE = 1;

            }
            if (labelB_TYPE == 1) {
                trial_counter++;
            }
        } while (labelB_TYPE == 1 && trial_counter <= 3);
        if (labelB_TYPE == 2) {
            total = Aplus + Aminus + Bplus + Bminus + ABplus + ABminus + Oplus + Ominus;
            Storefile();
            String ch;
            int loop_ctrl = 0, trial = 0;
            do {
                System.out.print("Do you want more?(y/n):");
                Scanner scan4 = new Scanner(System.in);
                ch = scan4.next().toLowerCase();
                if (ch.equals("y"))
                    request_blood();
                else if (ch.equals("n"))
                    blood_store();
                else {
                    loop_ctrl = 1;
                    trial++;
                }
            } while (loop_ctrl == 1 || trial <= 3);
            if (trial > 3) {
                blood_store();
            }
        } else {
            System.out.println("Request failed.Try again");
            blood_store();
        }

    }
}
