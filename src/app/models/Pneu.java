package app.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Pneu {
    private TypePneu type;
    private double pression;

    public Pneu(TypePneu type, double pression) {
        this.type = type;
        this.pression = pression;
    }

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("##.0");
        DecimalFormatSymbols dff = new DecimalFormatSymbols(Locale.US);
        df.setDecimalFormatSymbols(dff);
        String perssionDf = df.format(pression);
        return "[type = " + type + ", pression = " + perssionDf + "]";  
    }

    
}
