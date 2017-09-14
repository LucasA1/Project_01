package com.app.model.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

/**
 * Created by LukeMcDermott on 8/30/17.
 */
@NodeEntity
public class Event {

    @GraphId
    private Long graph_id;

    private String event_name;

    private Date event_date;
}
