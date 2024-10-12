package quoridor;

//both the pawns and the walls count as beak
//every single one box thing that we put on the board

import java.util.Objects;

public class Bead{
    int x;
    int y;
    String sign;
    int p;

    //overloading polymorphism
public Bead(int x, int y, String sign){
    this.x = x;
    this.y = y;
    this.sign = sign;
}
public Bead(int x, int y){
    this.x = x;
    this.y = y;
    this.sign = "@";
}


public void setSign(String sign){
    this.sign = sign;
}

public int getX(){ return x;}

public int getP(){ return (9 * (y - 1) + x);}
public void createP(){
    this.p = 9 * (y - 1) + x;
}

public int getY(){ return y;}

public String getSign(){ return sign;}

@Override
public String toString(){
    return "Bead(" + x + "," + y +
            "), sign='" + sign + '\'';
}

public String toString2(){
    return x + " " + y + " " + sign ;
}

@Override
public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    Bead bead = (Bead) o;
    return x == bead.x &&
            y == bead.y &&
            Objects.equals(sign, bead.sign);
}

@Override
public int hashCode(){
    return Objects.hash(x, y, sign);
}
}
