/*
 * Copyright 2015-2018 the original author or authors
 *
 * This software is licensed under the Apache License, Version 2.0,
 * the GNU Lesser General Public License version 2 or later ("LGPL")
 * and the WTFPL.
 * You may choose either license to govern your use of this software only
 * upon the condition that you accept all of the terms of either
 * the Apache License 2.0, the LGPL 2.1+ or the WTFPL.
 */
package de.measite.minidns.record;

import de.measite.minidns.DNSName;
import de.measite.minidns.Record.TYPE;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * A DNAME resource record.
 *
 * @see <a href="https://tools.ietf.org/html/rfc6672">RFC 6672 - DNAME Redirection in the DNS</a>
 */
public class DNAME extends RRWithTarget {

    public static DNAME parse(DataInputStream dis, byte[] data) throws IOException {
        DNSName target = DNSName.parse(dis, data);
        return new DNAME(target);
    }

    public DNAME(String target) {
        this(DNSName.from(target));
    }

    public DNAME(DNSName target) {
        super(target);
    }

    @Override
    public TYPE getType() {
        return TYPE.DNAME;
    }

}
