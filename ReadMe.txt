Что означает для Spring:

1.
 <bean class="ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository" id="inmemoryUserRepository"/>

 Можно сказать так:
 - создай и занеси в свой контекст экземпляр класса (бин) InMemoryUserRepository,
 - с идентификатором inmemoryUserRepository.

2.
 <bean class="ru.javawebinar.topjava.service.UserService">
     <property name="repository" ref="inmemoryUserRepository"/>
 </bean>

 Можно сказать так:
 - создай и занеси в свой контекст экземпляр класса (бин) UserService,
 - и присвой его проперти repository бин inmemoryUserRepository,
 - который возьми из своего контекста (см. п. 1).
