package org.example;

public enum Values {
    BIS(0),
    BSN(1),
    IBAN(2),
    KBO(3),
    NIHII(4),
    NIS(5),
    PV(6),
    RIZIV(7),
    RRN(8),
    UUID(9),
    BEN(10),
    LOREM(11),
    TEL(12),
    UTC(13),
    VEN(14);

    public final int value;
    private Values(int value) {
        this.value = value;
    }
}
