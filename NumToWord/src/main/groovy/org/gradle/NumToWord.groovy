package org.gradle


class NumToWord {
    static units = ["one","two","three","four","five","six","seven","eight","nine"]
    static ones = ["eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]
    static tens = ["ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"]
    static places = ["2":" hundred ", "3":" thousand ","6":" million ","9":" billion "]

    long num;
    int powerof10;
    def NumToWord(long num){
        this.num = num
        powerof10 = calcPowerOf10()
    }

    def toWord(){
        _toWord().trim()
    }

    def power = {of -> num.intdiv(10**of) > 0}

    private def calcPowerOf10(){
        power(9)?9: power(6)?6 : power(3)?3:2
    }

    private def _toWord(){
        if (num<=0) {
            ""
        }else if (num < 10){
            units[num.toInteger().mod(10)-1]
        }else if (num < 20) {
            ones[num.toInteger() % 10 - 1]
        }else if (num < 100) {
            tens[num.toInteger().intdiv(10) - 1] +
                    ((num % 10 > 0)?(" " + new NumToWord(num % 10).toWord()):"")
        }else {
            new NumToWord(num.intdiv(10**powerof10)).toWord() +
            places[powerof10.toString()] +
            new NumToWord(num.mod(10**powerof10)).toWord()
        }
    }

}

