package com.yangpeng.girl.controller;

import com.yangpeng.girl.common.InData;
import com.yangpeng.girl.common.OtherResult;
import com.yangpeng.girl.common.OtherResult2;
import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;
import com.yangpeng.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 关于girl模块的控制器
 */
@RestController
public class GirlController {
    /** slf4j日志*/
    private static  final Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlService.findAll();
    }

    /**
     * 新增一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public int girlAdd(@RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.save(girl);
    }

    /**
     * 通过id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlService.findById(id); //根据id查询数据
    }

    /**
     * 通过id更新一个女生
     * @param id
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public int girlUpdate(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.updateByGirl(girl); // 如果设置了主键id与数据库中的对应的话就更新那条数据
    }

    /**
     * 通过id删除一个女生
     * @param id
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public int girlDelete(@PathVariable("id") Integer id){
        return girlService.delete(id);//根据主键删除数据
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlService.findByAge(age);//根据年龄查询数据
    }

    /**
     * 事务管理，新增两个女生的信息
     */
    @PostMapping("/girls/two")
    public void saveTwoGirls(){
        System.out.println("新增两个女生的信息");
        girlService.saveTwoGirl();
    }

    /**
     * 通过验证后新增一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlsAndValidAge")
    public Object girlAndValidAgeAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println("未满18岁");
            logger.error("未满18岁");
            return "未满18岁";
        }
        return girlService.save(girl);//save返回的是添加进去的对象
    }

    /**
     * 通过验证后新增一个女生(返回值为Result)
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlsAndValidAge2")
    public Result<?> girlAndValidAgeAdd2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println("未满18岁");
            logger.error("未满18岁");
            return Result.error("未满18岁");
        }
        return Result.ok(girlService.save(girl));//save返回的是添加进去的对象
    }

    /**
     * 通过验证后新增一个女生(返回值为OtherResult)
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlsAndValidAge3")
    public OtherResult girlAndValidAgeAdd3(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println("未满18岁");
            logger.error("未满18岁");
            return OtherResult.error("未满18岁");
        }
        int i = girlService.save(girl);
//        Map<String,Object> map = new HashMap();
//        map.put("id",girl1.getId());
//        map.put("cupSize",girl1.getCupSize());
//        map.put("age",girl1.getAge());
//        OtherResult otherResult = new OtherResult();
//        otherResult.setData(map);
//        return otherResult;
        return OtherResult.ok().putDataValue("i",i);
    }

    /**
     * 通过验证后新增一个女生(返回值为OtherResult2)
     * @Valid开启对Girl对象的数据校验
     *BindingResult:封装了校验的结果
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlsAndValidAge4")
    public OtherResult2 girlAndValidAgeAdd4(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println("未满18岁");
            logger.error("未满18岁");
            return OtherResult2.error("未满18岁");
        }
        Object obj = girlService.save(girl);
        return OtherResult2.ok().putDataValue(obj);//save返回的是添加进去的对象
    }

    /**
     * 通过年龄查询女生列表
     * @param inData
     */
    @PostMapping(value = "/girls/byAge")
    public Result<?> findGirlsByAge(@RequestBody InData inData){
        Map<String,Object> inMap = inData.getInMap();
        Integer age = Integer.valueOf(inMap.get("age").toString());
        return Result.ok(girlService.findByAge(age));//根据年龄查询数据
    }

    /**
     * 根据id查询女生年龄(抛出Exception异常)
     * @param inData
     */
    @PostMapping(value = "/girls/byId")
    public Result<?> getAgeByIdThrowException(@RequestBody InData inData) throws Exception{
        Map<String,Object> inmap = inData.getInMap();
        Integer id = Integer.parseInt(inmap.get("id").toString());
        return girlService.getAgeByIdThrowException(id);
    }

    /**
     * 根据id查询女生年龄(抛出RuleException异常)
     * @param inData
     */
    @PostMapping(value = "/girls/byId2")
    public Result<?> getAgeByIdThrowRuleException(@RequestBody InData inData) throws RuleException {
        Map<String,Object> inmap = inData.getInMap();
        Integer id = Integer.parseInt(inmap.get("id").toString());
        return girlService.getAgeByIdThrowRuleException(id);
    }
}
