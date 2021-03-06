package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    private long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long timeEntryId = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                timeEntryId,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(timeEntryId, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        return timeEntries.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(Long timeEntryId, TimeEntry timeEntry) {
        if (find(timeEntryId) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                timeEntryId,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.replace(timeEntryId, updatedEntry);
        return updatedEntry;
    }

    @Override
    public void delete(Long timeEntryId) {
        timeEntries.remove(timeEntryId);
    }
}
