package it.fabioformosa.lab.springhandover;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/plugin")
public class HelloPluginController {
    //    @Autowired
    //    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    String hello() {
        return "Hello World by Plugin!";
    }

    //    @Data
    //    static class Result {
    //        private final int left;
    //        private final int right;
    //        private final long answer;
    //    }
    //
    //    // SQL sample
    //    @RequestMapping("calc")
    //    Result calc(@RequestParam int left, @RequestParam int right) {
    //        MapSqlParameterSource source = new MapSqlParameterSource()
    //                .addValue("left", left)
    //                .addValue("right", right);
    //        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
    //                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    //    }
}
