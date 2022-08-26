package srki2k.tweakedpetroleum.util.errorloggingutil.runtime;

import srki2k.tweakedpetroleum.TweakedPetroleum;
import srki2k.tweakedpetroleum.api.crafting.IReservoirType;
import srki2k.tweakedpetroleum.util.errorloggingutil.ErrorLoggingUtil;

import java.util.List;
import java.util.stream.Collectors;

import static flaxbeard.immersivepetroleum.api.crafting.PumpjackHandler.reservoirList;
import static srki2k.tweakedpetroleum.api.crafting.TweakedPumpjackHandler.rftTier;

public class RuntimeErrorLoggingUtil extends ErrorLoggingUtil {

    public void missingPowerTiersLog() {

        List<IReservoirType> powerTierNulls = reservoirList.keySet().
                stream().
                map(reservoirType -> (IReservoirType) reservoirType).
                filter(iReservoirType -> rftTier.get(iReservoirType.getPowerTier()) == null).
                collect(Collectors.toList());

        if (powerTierNulls.isEmpty()) {
            TweakedPetroleum.LOGGER.warn("Runtime missingPowerTiersLog() method was called, but return a empty error list");
            return;
        }

        super.logSetting();
        powerTierNulls.forEach(iReservoirType -> TweakedPetroleum.LOGGER.fatal("Reservoir with the ID (name)" + iReservoirType.getName() + "has no valid Power tier"));

        throw new Error("Check the Tweaked Petroleum logs");
    }
}