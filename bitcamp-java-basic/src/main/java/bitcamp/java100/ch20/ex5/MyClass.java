package bitcamp.java100.ch20.ex5;

import java.sql.Date;

public class MyClass {
    String varString;
    byte varByte;
    short varShort;
    int varInt;
    long varLong;
    float varFloat;
    double varDouble;
    boolean varBoolean;
    char varChar;
    Date varDate;

    @Override
    public String toString() {
        return "MyClass [varString=" + varString + ", varByte=" + varByte + ", varShort=" + varShort + ", varInt="
                + varInt + ", varLong=" + varLong + ", varFloat=" + varFloat + ", varDouble=" + varDouble
                + ", varBoolean=" + varBoolean + ", varChar=" + varChar + ", varDate=" + varDate + "]";
    }
    public Date getVarDate() {
        return varDate;
    }
    public void setVarDate(Date varDate) {
        this.varDate = varDate;
    }
    public String getVarString() {
        return varString;
    }
    public void setVarString(String varString) {
        this.varString = varString;
    }
    public byte getVarByte() {
        return varByte;
    }
    public void setVarByte(byte varByte) {
        this.varByte = varByte;
    }
    public short getVarShort() {
        return varShort;
    }
    public void setVarShort(short varShort) {
        this.varShort = varShort;
    }
    public int getVarInt() {
        return varInt;
    }
    public void setVarInt(int varInt) {
        this.varInt = varInt;
    }
    public long getVarLong() {
        return varLong;
    }
    public void setVarLong(long varLong) {
        this.varLong = varLong;
    }
    public float getVarFloat() {
        return varFloat;
    }
    public void setVarFloat(float varFloat) {
        this.varFloat = varFloat;
    }
    public double getVarDouble() {
        return varDouble;
    }
    public void setVarDouble(double varDouble) {
        this.varDouble = varDouble;
    }
    public boolean isVarBoolean() {
        return varBoolean;
    }
    public void setVarBoolean(boolean varBoolean) {
        this.varBoolean = varBoolean;
    }
    public char getVarChar() {
        return varChar;
    }
    public void setVarChar(char varChar) {
        this.varChar = varChar;
    }
    
    
    
    
    
}
