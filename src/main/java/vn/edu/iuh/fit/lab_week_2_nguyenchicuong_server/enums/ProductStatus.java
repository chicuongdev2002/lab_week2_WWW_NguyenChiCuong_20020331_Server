package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.enums;

public enum ProductStatus {
    ACTIVE(1),//Hoạt động
    IN_ACTIVE(0),//Không hoạt động
    TERMINATED(-1);//Tạm nghỉ
    private  int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
