package eu.darken.capod.pods.core.apple.airpods

import eu.darken.capod.pods.core.PodDevice
import eu.darken.capod.pods.core.apple.BaseAirPodsTest
import eu.darken.capod.pods.core.apple.HasAppleColor
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class AirPodsPro3Test : BaseAirPodsTest() {

    @Test
    fun `test AirPods Pro 3 - sample data from user`() = runTest {
        create<AirPodsPro3>("07 19 01 27 20 2B 21 8F 14 00 05 68 95 34 74 64 A5 3F 15 27 17 A4 81 41 53 EA 61") {

            pubPrefix shouldBe 0x01.toUByte()
            pubDeviceModel shouldBe 0x2720.toUShort()
            pubStatus shouldBe 0x2B.toUByte()
            pubPodsBattery shouldBe 0x21.toUByte()
            pubFlags shouldBe 0x8.toUShort()
            pubCaseBattery shouldBe 0xF.toUShort()
            pubCaseLidState shouldBe 0x14.toUByte()
            pubDeviceColor shouldBe 0x0.toUByte()
            pubSuffix shouldBe 0x05.toUByte()

            isLeftPodMicrophone shouldBe true
            isRightPodMicrophone shouldBe false

            isLeftPodInEar shouldBe true
            isRightPodInEar shouldBe true

            batteryLeftPodPercent shouldBe 0.2f
            batteryRightPodPercent shouldBe 0.1f

            isCaseCharging shouldBe false
            isRightPodCharging shouldBe false
            isLeftPodCharging shouldBe false
            batteryCasePercent shouldBe null

            podStyle.identifier shouldBe HasAppleColor.DeviceColor.WHITE.name

            model shouldBe PodDevice.Model.AIRPODS_PRO3
        }
    }
}