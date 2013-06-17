public class textAnalyse {

    String text;


    public textAnalyse(String text) {
        this.text = text;
        this.text = text.replace("ä", "ae");
        this.text = text.replace("ö", "oe");
        this.text = text.replace("ü", "ue");
        this.text = text.replace("ä", "AE");
        this.text = text.replace("ö", "OE");
        this.text = text.replace("ü", "UE");
    }

    public int[] getAnalyseAmount() {
        int[] alphabet = new int[26];

        char[] buchstabenListe = text.toLowerCase().toCharArray();

        for (int i = 0; i < buchstabenListe.length; i++) {
            if ((buchstabenListe[i] >= 'a' && buchstabenListe[i] <= 'z')) {
                alphabet[buchstabenListe[i] - 'a']++;
            }
        }
        return alphabet;
    }

    public float[] getAnaylsePercents() {
        int laenge = text.length();
        int countSpaces = 0;
        for (int wortlänge = 0; wortlänge < text.length();wortlänge++){
            if((text.charAt(wortlänge))== ' '){
                  countSpaces++;
            }
        }
        float percentageFactor = 100F / (laenge-countSpaces);
        int[] amount = getAnalyseAmount();
        float[] percentage = new float[26];
        for (int alphabet = 0; alphabet < percentage.length; alphabet++) {
            percentage[alphabet] = amount[alphabet] * percentageFactor;
        }
        return percentage;
    }

    public String getCaesarChiffre(int setting) {
        int countAlphabet = 26;
        int tmp = 0;
        int settingCountTop = 0;
        String ergebnis = "";
        char[] textArray = text.toCharArray();
        while (setting >= countAlphabet) {
            setting -= 26;
        }
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] >= 'A' && textArray[i] <= 'Z') {
                switch (textArray[i]) {
                    case 'Z':
                        textArray[i] = (char) ('A' + setting);
                        break;
                    default:
                        while (textArray[i] + setting > 'Z') {
                            setting--;
                            settingCountTop++;
                        }
                        if (settingCountTop != 0) {
                            textArray[i] = (char) ('A' + setting);
                        } else {
                            textArray[i] += setting;
                            break;
                        }
                }
            } else if (textArray[i] >= 'a' && textArray[i] <= 'z') {
                if (textArray[i] >= 'a' && textArray[i] <= 'z') {
                    switch (textArray[i]) {
                        case 'z':
                            textArray[i] = (char) ('a' + setting);
                            break;
                        default:
                            while (textArray[i] + setting > 'z') {
                                setting--;
                                settingCountTop++;
                            }
                            if (settingCountTop != 0) {
                                textArray[i] = (char) ('a' + setting);
                            } else {
                                textArray[i] += setting;
                                break;
                            }
                    }
                }
            }
            ergebnis += String.valueOf(textArray[i]);
        }
        return ergebnis;
    }

    public String getUpperLower(String text, boolean setting) {
        String ergebnis = "";
        if (!setting) {
            return text.toLowerCase();
        } else {
            return text.toUpperCase();
        }
    }
    // laut Aufgabe static
   /* public static String getUpperLower(String text, boolean setting) {
        
        if (!setting) {
            text= text.toLowerCase();
        } if(setting) {
            text = text.toUpperCase();
        }
        return text;
    } *\

}
