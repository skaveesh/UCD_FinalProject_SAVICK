package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.core.CompanyStock;
import com.smsimulator.core.Sector;
import com.smsimulator.gsoncore.Market;
import com.smsimulator.gsoncore.Stock;
import com.smsimulator.gsoncore.StockMarket;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-13.
 */
public class StockMarketRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            //response gson object
            List<Sector> sectorList = new Broker().getSectorList();

            StockMarket stockMarket = new StockMarket();
            List<Market> marketItemList = new ArrayList<>();
            for (Sector sector : sectorList) {
                Market marketItem = new Market();
                List<Stock> stockList = new ArrayList<>();

                for (CompanyStock companyStock : sector.stockList) {
                    Stock stock = new Stock();
                    stock.setCompanyName(companyStock.getCompanyName());
                    stock.setStock(companyStock.getStockName());
                    stock.setPriceArray(companyStock.getStockPriceArray());
                    stockList.add(stock);
                }

                marketItem.setSectorName(sector.sectorName);
                marketItem.setStocks(stockList);
                marketItemList.add(marketItem);
            }

            stockMarket.setMarket(marketItemList);

            response.setEntity(InboundRoot.gson.toJson(stockMarket), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);

        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
