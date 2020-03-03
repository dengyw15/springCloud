package com.dyw.springcloud.controller;

import com.dyw.springcloud.entity.Dept;
import com.dyw.springcloud.service.DeptService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2020-02-27 13:11:44
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Autowired
    private DeptService deptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public Dept selectOne(@PathVariable("id") Long id) {
        return this.deptService.queryById(id);
    }

    @PostMapping("add")
    public void add(@RequestBody Dept dept) {
        deptService.insert(dept);
    }

    @GetMapping("list/{offset}/{limit}")
    public List<Dept> list(@PathVariable(value = "offset", required = false) int offset, @PathVariable(value = "limit", required = false) int limit) {

        List<Dept> depts = deptService.queryAllByLimit(offset, limit);
        return depts;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            iterator.remove();
        }

        System.out.println(map.size());
    }
}