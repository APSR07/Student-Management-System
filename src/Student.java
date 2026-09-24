public class Student {
        private int id;
        private String name;
        private String dob;
        private String mobileNumber;
        private String address;
        private String course;


        public Student(){}

        public Student(String name, String dob, String mobileNumber, String address, String course){
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.mobileNumber = mobileNumber;
            this.address = address;
            this.course = course;
        }

        public Student(int id, String name, String dob, String mobileNumber, String address, String course){
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.mobileNumber = mobileNumber;
            this.address = address;
            this.course = course;
        }

        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            if (name == null || name.isEmpty()){
                System.out.println("Invalid name");
                return;
            }
                this.name = name;
        }

        public String getDob(){
            return dob;
        }

        public void setDob(String dob){
            this.dob = dob;
        }

        public String getMobileNumber(){
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber){
            if (mobileNumber == null || !mobileNumber.matches("[1-9]\\d{9}")) {
                System.out.println("Invalid mobile number ");
                return;
            }
            this.mobileNumber = mobileNumber;
        }

        public String getAddress(){
            return address;
        }

        public void setAddress(String address){
            this.address = address;
        }

        public String getCourse(){
            return course;
        }

        public void setCourse(String course){
            if (course == null || course.isEmpty()){
                System.out.println("Invalid course");
                return;
            }
            this.course = course;
        }

        @Override
        public String toString() {
            return "ID: " + id +
                "\nName: " + name +
                "\nMobile: " + mobileNumber +
                "\nAddress: " + address +
                "\nCourse: " + course;
    }
}
