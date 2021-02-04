##### 乐观锁的实现方式：
    1. 取出记录时，获取当前的version
    2.更新时，带上这个version
    3.执行更新时，set version = new version where version=oldversion
    4.如果version不对,就更新失败  
    
**乐观锁：1.先查询，获取版本号version+1**  
 --a线程  
update user set name="hq",version=version+1 where id =2 and version=1

--b线程抢先完成，这个时候version=2 会导致a线程修改失败  
update user set name="hq",version=version+1 where id =2 and version=1


