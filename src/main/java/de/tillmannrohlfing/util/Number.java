package de.tillmannrohlfing.util;

import de.tillmannrohlfing.binaryTrees.ComparableContent;

public class Number implements ComparableContent<Number> {
    Integer number;
    public Number (Integer pNumber){
        number = pNumber;
    }
    public boolean isEqual(Number pNumber){
        if(this.number.equals(pNumber.getValue()))
            return true;
        return false;
    }
    public boolean isLess(Number pNumber){
        if(this.number < pNumber.getValue())
            return true;
        return false;
    }
    public boolean isGreater(Number pNumber){
        if(this.number > pNumber.getValue())
            return true;
        return false;
    }
    public Integer getValue(){
        return number;
    }
    public void setNumber(Integer pNumber){

    }
    public void setNumber(Number pNumber){
        number = pNumber.getValue();
    }
    public String toString(){
        return number.toString();
    }
}
