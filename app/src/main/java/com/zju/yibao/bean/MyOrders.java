package com.zju.yibao.bean;

import java.util.List;

/**
 * Created by Atlas on 16/2/5.
 */
public class MyOrders {

    /**
     * ordersCarId  : 23123123
     * studentId  : 34534534
     * courseName  : 声乐课程
     * teacherName  : 王老师
     * teacherAge  : 23
     * organizationName  : 科瑞教育
     * organizationAddr  : 浙江省宁波市
     * education  : 硕士
     * time  : 2016-02-05 15:22:20
     * count  : 2
     * totalPrice  : 300
     */

    private List<OrdersEntity> orders;

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public static class OrdersEntity {
        private String ordersCarId;
        private String studentId;
        private String courseName;
        private String teacherName;
        private String teacherAge;
        private String organizationName;
        private String organizationAddr;
        private String education;
        private String time;
        private int count;
        private int totalPrice;

        public void setOrdersCarId(String ordersCarId) {
            this.ordersCarId = ordersCarId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public void setTeacherAge(String teacherAge) {
            this.teacherAge = teacherAge;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public void setOrganizationAddr(String organizationAddr) {
            this.organizationAddr = organizationAddr;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getOrdersCarId() {
            return ordersCarId;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public String getTeacherAge() {
            return teacherAge;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public String getOrganizationAddr() {
            return organizationAddr;
        }

        public String getEducation() {
            return education;
        }

        public String getTime() {
            return time;
        }

        public int getCount() {
            return count;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

    }
}