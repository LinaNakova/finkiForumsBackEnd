package bazi.finki.ukim.mk.finkiforums.Service;

import java.util.List;
import java.util.Map;

public interface AdminPanelService {
    List<Map<String, Object>> getStats(int id);
}
