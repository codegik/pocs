package com.codegik.context.service;

import com.codegik.context.domain.Address;
import com.codegik.context.repository.AddressRepository;
import com.codegik.context.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Optional<Address> createAddress(Address address) {
        // Validate that the user exists before creating an address for them
        return userRepository.findById(address.getUserId())
                .map(user -> addressRepository.save(address));
    }

    public Optional<Address> updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id).map(address -> {
            address.setStreet(addressDetails.getStreet());
            address.setCity(addressDetails.getCity());
            address.setState(addressDetails.getState());
            address.setZipCode(addressDetails.getZipCode());
            // We don't update the userId to prevent changing ownership
            return addressRepository.save(address);
        });
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
