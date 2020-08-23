package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(lazyInit = true)
@Profile("!test")
public class TransactionConfig {
    /*@Bean
    SavePublicationTransaction<SimplePublication> beanSavePublicationTransactionSimplePublication
            (PublicationDetailsRepository repository) {
        return new SaveSimplePublicationTransaction(repository);
    }*/

    /*@Bean
    DeleteTransaction beanDeleteTransaction(PublicationDetailsRepository repository) {
        return new DeleteTransactionImpl(repository);
    }*/
}
