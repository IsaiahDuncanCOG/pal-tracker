package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry obj);
    TimeEntry find(Long timeEntryId);
    List<TimeEntry> list();
    TimeEntry update(Long timeEntryId, TimeEntry timeEntry);
    void delete(Long timeEntryId);

}
