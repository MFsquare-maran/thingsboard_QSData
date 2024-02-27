/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.alarm.rule.filter;

import lombok.Data;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.EntityId;

import java.util.List;

import static org.thingsboard.server.common.data.EntityType.ASSET_PROFILE;

@Data
public class AlarmRuleAssetTypeEntityFilter implements AlarmRuleEntityFilter {

    private final List<AssetProfileId> assetProfileIds;

    @Override
    public AlarmRuleEntityFilterType getType() {
        return AlarmRuleEntityFilterType.ASSET_TYPE;
    }

    @Override
    public boolean isEntityMatches(EntityId entityId) {
        return entityId.getEntityType() == ASSET_PROFILE && assetProfileIds.contains((AssetProfileId) entityId);
    }
}