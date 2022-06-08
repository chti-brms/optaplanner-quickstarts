/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acme.common.persistence;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.common.domain.Lesson;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class LessonRepository implements PanacheRepository<Lesson> {

    public List<Lesson> listAllByProblemId(long problemId) {
        return find(Lesson.TENANT_FIELD, Sort.by("subject").and("teacher").and("studentGroup").and("id"), problemId)
                .list();
    }
}