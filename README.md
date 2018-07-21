# java-database-framework-Service


Working on developing a Restful web service for java-database-framework to easen up the process for backend development for java applications by handling jdbc and sql commands on its own through requests from the internet.

Just provide credentials, table and column identifiers and you are good to go . :)

The reason it/i am creating and parsing XMLs is to provide a two way approach to providing required parametrers, either you can call the functions with required parameters or you can edit the XMLs and provide the necesarry parameters there. 

Will be working for mysql only, at least as of now . :(

mysql connector is required on build path for library as is a dependency of it.
I do not own any rights for mysql connector,  though it is available for free at : https://dev.mysql.com/downloads/connector/j/5.1.html

Mappings at 8080 are as follows : 

1.) /init : First thing to do for creating a new table is to provide db credentials and these details will be picked up for         every new table creation untill you change it, Accepts parameter as :
<ul>
  <li>          a. connect : Connection string  </li>
  <li>       b. table   : table name      </li>
  <li>           c. user    : user name </li>
  <li>         d. pass    : password</li>
  </ul>
            
2.) /create : Takes XML request body in format, db credentials defined here are not used but are requirede in XML : 

 ```xml
 <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<Create-Table>
    <Connection-String String="jdbc:mysql://localhost:3306/mydb"/>
    <Schema Name="service"/>
    <username Name="root"/>
    <Password Name="root"/>
    <Column>
        <Column-Name>col_11</Column-Name>
        <Column-Data-Type>int</Column-Data-Type>
        <Is-Primary-Key>Y</Is-Primary-Key>
        <Default>2</Default>
    </Column>
    <Column>
        <Column-Name>col_13</Column-Name>
        <Column-Data-Type>int</Column-Data-Type>
        <Is-Primary-Key>N</Is-Primary-Key>
        <Default>NOT SET</Default>
    </Column>
</Create-Table>

```

3.) /auto : AutoIncrements a particular column after checking all sql validations, accepts parameters as : 
        <ul>
  <li>  column : column name </li>
  <li> seed : starting value for auto increment </li>
  <li>       NOTE : TAKES TABLE NAME SET USING /init </li>
      </ul>
       
4.) /credentials : If you have an already exisiting db structure and want to create beans for it use this, it accepts              parameteres :
<ul>
  <li>            (a) connection : Connection string </li>
  <li>           (b) db         : table name </li>
  <li>          (c) user       : user name </li>
  <li>          (d) pass       : password </li>

</ul>

   almost same as /init but are kept in different file as that of /init so they are not used for table creation or              setting auto increment . After setting this you have to use following mapping :

5.) /map : Used after /credentials to auto create beans.

6.) /getall : Retrieves all the data from a given table in JSON, parameter : 
          <ul>
  <li>     a. table : table name </li>
  </ul>
7.) /getwhere : Retrieves all data where a particular column is equal to something, accepts parameter: 
<ul>
  <li>           a. table : table name </li>
  <li>       b. column : column name </li>
  <li>          c. condition : what column data should be equal to  </li>
  </ul>
8.) /droptable : drops a table, accepts parameter
<ul>
  <li>            a. table : table name  </li>
  </ul>
                
9.) /dropcol : drops a column, accepts parameter :

<ul>
  <li>            a. table : table name  </li>
              <li>   b.column : column name  </li>
                 </ul>
10.) /changetable : Changes a table name and takes parameters as :

<ul>
  <li>              a. oldname : Current name of table </li>
  <li>              b. newname : Name it should be set to </li>
  </ul>
                  
11.) /changecol : Changes a column name, accepts parameters as :

<ul>
  <li>            a. table : table name </li>
  <li>         b. oldname : Current name of column </li>
  <li>        c. newname : Name it should be set to </li>
  </ul>
