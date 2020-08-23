## Build
1. Create application.properties file with following information:  
`spring.datasource.url`  
`spring.datasource.driverClassName`   
`spring.datasource.username`  
`spring.datasource.password`  
`spring.jpa.hibernate.ddl-auto`

## Checklist on adding new type of Publication
1. Add new `Publication.Type` enum value (ex. `NEW_PUB`)
2. Create new class implementing `Publication` in domain package (ex. `NewPub`)
3. Overwrite `getType()` method in `NewPub` class with `return Publication.Type.NEW_PUB`
4. Extend `PublicationDetails` with fields that are added by your new `Publication` implementation 
5. Add `NewPub` handling to `map` method of `ReadTransactionImpl` class
6. Extend `CompositePublication` with fields that are added by your new `Publication` implementation
7. Create new class implementing `Morph<NewPub>` interface (ex. `NewPubMorpher`)
8. Add `NewPubMorpher` usage to `MorphKeeper` class

## Custom rules for writing code
1. If test uses JpaRepository then its name should contain "JpaDatabaseTest". It excludes test from test script.

#### Useful links:
1. [Spring JPA with enum]

[Spring JPA with enum]:https://www.baeldung.com/jpa-persisting-enums-in-jpa
