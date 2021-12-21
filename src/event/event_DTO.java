package event;

public class event_DTO { //event 테이블의 정보를 담는 클래스 
   private int Enum;   //PK
   private int Cunum;
   
   public int getEnum() {
      return Enum;
   }
   public void setEnum(int Enum) {
      this.Enum = Enum;
   }
   public int getCunum() {
      return Cunum;
   }
   public void setCunum(int Cunum) {
      this.Cunum = Cunum;
   }
   
   
}