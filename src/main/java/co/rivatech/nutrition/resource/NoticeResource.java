package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Notice;
import co.rivatech.nutrition.service.NoticeService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/notice")
public class NoticeResource {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/add")
    @ApiOperation(value = "Add notice details")
    public Notice addNotice(@Nonnull @RequestBody Notice notice) {
        return noticeService.save(notice);
    }

    @GetMapping("/getNotice")
    @ApiOperation(value = "Currently it returns all the notices, later on we may need to divide based on district etc.")
    public List<Notice> getNotice(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Notice> pagedResult = noticeService.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        else {
            return Collections.emptyList();
        }
    }
}
