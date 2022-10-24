package com.dotcomtirocinio.esercizio040;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "parametro",
        "risultato"
})
@XmlRootElement(name = "parametri")
public class Parametri<P> {

    @XmlElement(required = true)
    protected List<Parametri.Parametro> parametro;
    @XmlElement(required = true)
    protected String risultato;



    public Parametri() {

    }

    @Override
    public String toString() {
        return "Parametri{" +
                "parametro=" + parametro +
                ", risultato='" + risultato + '\'' +
                '}';
    }

    public List<Parametro> getParametro() {
        if (parametro == null) {
            parametro = new ArrayList<Parametro>();
        }
        return this.parametro;
    }

    public String getRisultato() {
        return risultato;
    }



    public void setRisultato(String value) {
        this.risultato = value;
    }

    public void unmarshallList() {
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "maggiore",
            "minore"
    })
    public static class Parametro {

       protected BigDecimal maggiore;
        protected BigDecimal minore;

        @Override
        public String toString() {
            return "Parametro{" +
                    "nome=" + nome +
                    ", minore=" + minore +
                    ", maggiore='" + maggiore + '\'' +
                    '}';
        }

        public Parametro() {
        }

        @XmlAttribute(name = "nome", required = true)
        protected String nome;

        public BigDecimal getMaggiore() {
            return maggiore;
        }


        public void setMaggiore(BigDecimal value) {
            this.maggiore = value;
        }


        public BigDecimal getMinore() {
            return minore;
        }


        public void setMinore(BigDecimal value) {
            this.minore = value;
        }


        public String getNome() {
            return nome;
        }


        public Parametro maggiore() {
            return this;
        }

        public BigDecimal minore() {
            return null;
        }
    }


}
