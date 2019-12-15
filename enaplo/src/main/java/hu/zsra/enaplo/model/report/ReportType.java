package hu.zsra.enaplo.model.report;

public enum ReportType {

    END_OF_THE_YEAR,
    END_OF_THE_SEMESTER;

    public String getReportName() {
        return name();
    }
}
