package com.azshop.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RevenueData {
    private LocalDate date;
    private BigDecimal revenue;

    public RevenueData(LocalDate date, BigDecimal revenue) {
        this.date = date;
        this.revenue = revenue;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
    
    public static List<RevenueData> generateRevenueDataList(List<BigDecimal> revenueList) {
        List<RevenueData> revenueDataList = new ArrayList<RevenueData>();
        LocalDate currentDate = LocalDate.now().minusDays(1);
       
        for (BigDecimal revenue : revenueList) {
            revenueDataList.add(new RevenueData(currentDate, revenue));
            currentDate = currentDate.minusDays(1);
        }

        return revenueDataList;
    }
}
