package com.wenwei.stock.dbservice.resource;


import com.wenwei.stock.dbservice.model.Quote;
import com.wenwei.stock.dbservice.model.Quotes;
import com.wenwei.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author:zhou_wenwei
 * mail:
 * date:2017/12/18
 * description:
 */
@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {
    @Autowired
    private QuotesRepository quotesRepository;
    @GetMapping("/{userName}")
//    @PreAuthorize("hasAuthority('query-demo')")
    public String getQuotes(@PathVariable("userName") final String name){
        return "wenwei ";
//        return getQuoteByUserName(name);
    }

    private List<String> getQuoteByUserName(@PathVariable("userName") String name) {
        return quotesRepository.findByUserName(name)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){
         quotes.getQuotes()
                .stream()
                .map(quote-> new Quote(quotes.getUserName(),quote))
                .forEach(quotesRepository::save);
        return getQuoteByUserName(quotes.getUserName());
    }
    @PostMapping("/delete/{userName}")
    public List<String> delete(@PathVariable("userName") final String userName){
        List<Quote> quotes = quotesRepository.findByUserName(userName);
        quotesRepository.delete(quotes);
        return getQuoteByUserName(userName);
    }

}
