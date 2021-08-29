package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.rivatech.nutrition.model.Notice;
import co.rivatech.nutrition.repository.NoticeRepository;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public Notice save(final Notice notice) {
        return noticeRepository.save(notice);
    }

    public Page<Notice> findAll(final Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
