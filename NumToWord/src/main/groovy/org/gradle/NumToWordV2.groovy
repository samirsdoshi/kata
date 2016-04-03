package org.gradle


class NumToWordV2 {
    static units = ["one","two","three","four","five","six","seven","eight","nine"]
    static ones = ["eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]
    static tens = ["ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"]
    static places = ["1":"", "2":" hundred ", "3":" thousand ","6":" million ","9":" billion "]
    static def EMPTY = ""
    static def SPACE = " "

    long num;
    int powerof10;
    def NumToWordV2(long num){
        this.num = num
        powerof10 = calcPowerOf10()
    }

    def toWord(){
        _toWord().trim()
    }

    def power = {of -> num.intdiv(10**of) > 0}

    private def calcPowerOf10(){
        power(9)?9: power(6)?6 : power(3)?3: power(2)?2:1
    }

    private def _toWord(){
        if (num<=0) {
            EMPTY
        }else if (num < 20) {
            unitsWord(num)
        }else if (num < 100) {
            tens[num.toInteger().intdiv(10) - 1] +
                    ((num % 10 > 0)?(" " + new NumToWord(num % 10).toWord()):"")
        }else {
            new NumToWordV2(num.intdiv(10**powerof10)).toWord() +
            places[powerof10.toString()] +
            new NumToWordV2(num.mod(10**powerof10)).toWord()
        }
    }

    private static def unitsWord(long num){
        if (num.mod(100) >=10 && num.mod(100) <20) ones[num.toInteger().mod(10)-1]
        else if (num.mod(10)>0) units[num.toInteger().mod(10)-1]
        else EMPTY
    }

}

